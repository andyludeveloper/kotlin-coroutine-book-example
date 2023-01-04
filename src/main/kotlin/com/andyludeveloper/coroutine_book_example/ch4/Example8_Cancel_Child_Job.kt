package com.andyludeveloper.coroutine_book_example.ch4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = launch {
        val childJob1 = launch {
            while(true){
                println("heavy work")
            }
        }

        val childJob2 = launch {
            childJob1.join()
            println("Job1 is cancelled")

            delay(200)
            println("Job2 done")
        }

        childJob1.cancel()
        childJob2.join()
        println("parent is not cancelled")
    }

    println("start")
    parentJob.join()
    println("done")
}
