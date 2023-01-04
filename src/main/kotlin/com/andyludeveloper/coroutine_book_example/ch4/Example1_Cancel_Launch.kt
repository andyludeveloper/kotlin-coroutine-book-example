package com.andyludeveloper.coroutine_book_example.ch4

import kotlinx.coroutines.*
fun main() = runBlocking {
    val job1 = launch {
        delay(100)
        println("Job1 done")
    }

    val job2 = launch {
        delay(1000)
        println("Job2 done")
    }

    println("start launch")
    delay(300)
    job2.cancel()
}