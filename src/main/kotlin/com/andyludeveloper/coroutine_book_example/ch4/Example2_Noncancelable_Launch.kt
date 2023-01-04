package com.andyludeveloper.coroutine_book_example.ch4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        while (true) {
            println("Do something...")
        }
    }

    println("start")
    delay(1000)
    job.cancel()
    println("Done")
}
