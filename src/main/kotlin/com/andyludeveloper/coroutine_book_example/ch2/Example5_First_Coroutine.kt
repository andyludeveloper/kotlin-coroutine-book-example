package com.andyludeveloper.coroutine_book_example.ch2

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        println("Coroutine")
    }
    println("Start")
}
