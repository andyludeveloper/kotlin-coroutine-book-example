package com.andyludeveloper.coroutine_book_example.ch3

import kotlinx.coroutines.*

fun main() = runBlocking {
    val result1 = async {
        println("async task 1, ${Thread.currentThread().name}")
        delay(100)
        100
    }

    val result2 = async {
        println("async task 2, ${Thread.currentThread().name}")
        delay(200)
        200
    }

    println("Result is ${result1.await() + result2.await()}")
}
