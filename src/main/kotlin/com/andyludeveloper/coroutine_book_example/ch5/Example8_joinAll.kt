package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val jobs = mutableListOf<Job>()

    repeat(10) {
        jobs.add(launch {
            delay(100)
            println("job: $it")
        })
    }

    jobs.joinAll()
    println("done")
}
