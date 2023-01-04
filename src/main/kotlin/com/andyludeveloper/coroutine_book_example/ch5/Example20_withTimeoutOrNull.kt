package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        println("job start")

        val withTimeoutResult = withTimeoutOrNull(200L) {
            println("withTimeout start")
            repeat(10) {
                println("delay $it times")
                delay(10L)
            }
            "ok"
        }
        println("job done: $withTimeoutResult")
    }

    job.join()
    println("done")
}
