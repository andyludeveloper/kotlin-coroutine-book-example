package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        println("child, thread: ${Thread.currentThread().name}")
        try {
            withContext(Dispatchers.Default) {
                delay(200L)
                println("withContext, thread: ${Thread.currentThread().name}")
            }
        } catch (e: CancellationException) {
            println("withContext has been cancelled")
        }
        println("child job done")
    }
    delay(100L)
    job.cancel()
    job.join()
    println("parent, thread: ${Thread.currentThread().name}")
}
