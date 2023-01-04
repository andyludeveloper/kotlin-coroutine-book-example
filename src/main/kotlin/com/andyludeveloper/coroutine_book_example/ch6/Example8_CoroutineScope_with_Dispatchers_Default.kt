package com.andyludeveloper.coroutine_book_example.ch6

import kotlinx.coroutines.*

fun main() = runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)
    scope.launch {
        println("launch run in ${Thread.currentThread().name}")
    }
    println("start: ${Thread.currentThread().name}")
}
