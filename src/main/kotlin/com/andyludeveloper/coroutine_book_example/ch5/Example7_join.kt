package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val childJob = launch { //child job
        delay(100)
        println("child job done")
    }
    childJob.join()
    println("parent job done")
}
