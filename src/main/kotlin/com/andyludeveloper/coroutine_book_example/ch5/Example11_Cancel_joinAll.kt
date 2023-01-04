package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val jobs = mutableListOf<Job>()

    repeat(10) { //1
        jobs.add(launch(start = CoroutineStart.LAZY) {
            delay(100L)
            println("job $it")
        })
    }

    val job = launch { // 3
        try { //5
            println("start multiple jobs")
            jobs.joinAll()
            println("done")
        } catch (e: CancellationException) {
            println(e.message)
        }
    }

    delay(500L) // 2
    job.cancel() // 4
    println("done") //6
}
