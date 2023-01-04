package com.andyludeveloper.coroutine_book_example.ch6

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch(Dispatchers.Unconfined) {
        println("Before delay, thread: ${Thread.currentThread().name}")
        delay(500)
        println("After delay, thread: ${Thread.currentThread().name}")
    }

    job.join()
    println("done")
}
