package com.andyludeveloper.coroutine_book_example.ch3

import kotlinx.coroutines.*

fun main() = runBlocking {
    val result = async {
        delay(100)
        true
    }
    println("Start async task")
    println("Result is ${result.await()}")
}

