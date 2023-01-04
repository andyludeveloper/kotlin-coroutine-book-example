package com.andyludeveloper.coroutine_book_example.ch6

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch(Dispatchers.Default) {
        println("child coroutine: ${Thread.currentThread().name}")
    }
    println("parent coroutine: ${Thread.currentThread().name}")
}
