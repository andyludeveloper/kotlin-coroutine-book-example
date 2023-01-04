package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        println("job start")
        withTimeout(200L) {
            println("withTimeout start")
            repeat(10) {
                println("delay $it times")
                delay(100L)
            }
            println("withTimeout end")
        }
        println("job done")
    }

    job.join()
    println("done")
}
