package com.andyludeveloper.coroutine_book_example.ch4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        while (true) {
            ensureActive()
            println("Do something...")
        }
    }
    println("start")
    delay(100)
    job.cancel()
    println("Done")
}
