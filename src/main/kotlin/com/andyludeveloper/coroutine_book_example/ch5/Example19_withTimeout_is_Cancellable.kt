package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        println("job start")
        try {
            withTimeout(200L) {
                println("withTimeout start")
                repeat(10) {
                    println("delay $it times")
                    delay(100L)
                }
                println("withTimeout end")
            }
        } catch (e: TimeoutCancellationException) {
            println(e.message)
        }
        println("job done")
    }

    delay(100L)
    job.cancel()
    println("done")
}
