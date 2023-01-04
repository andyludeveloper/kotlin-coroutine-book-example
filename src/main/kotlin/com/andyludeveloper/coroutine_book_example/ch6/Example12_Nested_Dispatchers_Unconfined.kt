package com.andyludeveloper.coroutine_book_example.ch6

import kotlinx.coroutines.*

fun main() = runBlocking {
    withContext(Dispatchers.Unconfined) {
        println("A: ${Thread.currentThread().name}")
        delay(100)
        withContext(Dispatchers.Unconfined) {
            println("B: ${Thread.currentThread().name}")
        }
        println("C: ${Thread.currentThread().name}")
    }
    println("Done")
}
