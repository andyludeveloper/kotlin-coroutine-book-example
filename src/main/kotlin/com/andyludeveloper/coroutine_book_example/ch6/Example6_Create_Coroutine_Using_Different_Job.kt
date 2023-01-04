package com.andyludeveloper.coroutine_book_example.ch6

import kotlinx.coroutines.*

fun main() = runBlocking {
    val coroutineScope = CoroutineScope(Job())
    coroutineScope.launch {
        delay(200L)
        println("run first job")
        launch(Job()) {
            try {
                println("another job")
                delay(800L)
            } catch (e: CancellationException) {
                println(e.message)
            }
        }
    }

    delay(500L)
    coroutineScope.cancel()
    println("done")
}
