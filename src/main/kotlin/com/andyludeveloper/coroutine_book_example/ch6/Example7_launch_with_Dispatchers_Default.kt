package com.andyludeveloper.coroutine_book_example.ch6

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch(Dispatchers.Default) {
        println("launch run in ${Thread.currentThread().name}")
    }
    println("start: ${Thread.currentThread().name}")
}
