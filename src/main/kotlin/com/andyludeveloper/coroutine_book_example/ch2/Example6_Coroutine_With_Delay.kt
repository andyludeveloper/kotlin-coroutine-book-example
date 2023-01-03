package com.andyludeveloper.coroutine_book_example.ch2

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(100)
        println("Coroutine")
    }
    println("Start")
}
