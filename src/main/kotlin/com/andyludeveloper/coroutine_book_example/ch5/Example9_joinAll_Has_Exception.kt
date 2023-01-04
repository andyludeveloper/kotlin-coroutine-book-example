package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val jobs = mutableListOf<Job>()

    repeat(10) {
        jobs.add(launch {
            withTimeout(500) {
                delay(100L * it)
                println("job: $it")
            }
        })
    }
    jobs.joinAll()
    println("done")
}
