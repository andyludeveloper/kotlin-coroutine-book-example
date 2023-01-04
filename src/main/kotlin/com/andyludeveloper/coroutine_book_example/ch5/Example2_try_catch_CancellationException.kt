package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job1 = launch {
        try {
            println("Job1 start")
            delay(100)
            println("Job1 end")
        } catch (e: CancellationException) {
            println("Job1 has been canceled")
        }
    }

    launch {
        println("Job2 start")
        job1.cancel()
        println("Job2 end")
    }

    launch {
        println("Job3 start")
        delay(300)
        println("Job3 end")
    }

    println("Start")
}
