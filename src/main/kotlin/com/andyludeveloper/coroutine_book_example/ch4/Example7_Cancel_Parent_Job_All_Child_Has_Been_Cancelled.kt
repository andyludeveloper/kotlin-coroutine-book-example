package com.andyludeveloper.coroutine_book_example.ch4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = launch { //parent job
        launch {
            delay(500)
            println("Job1 done")
        }

        launch {
            delay(1000)
            println("Job2 done")
        }
    }

    println("start launch")
    delay(100)
    parentJob.cancel()
}
