package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        println("Job1 start")
        delay(100)
        println("Job1 end")
    }

    launch {
        println("Job2 start")
        delay(200)
        println("Job2 end")
    }

    launch {
        println("Job3 start")
        delay(300)
        println("Job3 end")
    }

    println("Start")
}
