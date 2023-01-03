package com.andyludeveloper.coroutine_book_example.ch2

import kotlinx.coroutines.*

fun main() = runBlocking{
    var i = 0
    val job = launch {
        while (true) {
            println("do something: $i")
            Thread.sleep(100)
            i++
        }
    }

    println("start")
    delay(300)
    job.cancel()
    println("done")
}