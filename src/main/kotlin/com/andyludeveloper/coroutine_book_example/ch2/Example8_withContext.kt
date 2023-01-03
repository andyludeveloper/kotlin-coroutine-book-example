package com.andyludeveloper.coroutine_book_example.ch2

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(100)
        println("launch, ${Thread.currentThread().name}")

        withContext(Dispatchers.Default) {
            delay(100)
            println("inner, ${Thread.currentThread().name}")
        }
    }
    println("Start, ${Thread.currentThread().name}")
    delay(500)
    println("End, ${Thread.currentThread().name}")
}

