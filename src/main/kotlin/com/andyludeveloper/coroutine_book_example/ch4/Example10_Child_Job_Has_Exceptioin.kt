package com.andyludeveloper.coroutine_book_example.ch4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = launch {
        val childJob1 = launch {
            println("childJob1 start")
            delay(200)
            throw Error("Something incorrect")
        }

        val childJob2 = launch {
            println("childJob2 start")
            //childJob1.join()
            println("childJob1 is cancelled")

            delay(200)
            println("childJob2 done")
        }
        childJob2.join()
        println("parent is not cancelled")
    }

    println("start")
    parentJob.join()
    println("done")
}
