package com.andyludeveloper.coroutine_book_example.ch7

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {
    val channel = Channel<Int>()
    launch(Dispatchers.Default) {
        repeat(10) {
            delay(200)
            println("Send: $it ${Thread.currentThread().name}")
            channel.send(it)
        }
    }
    repeat(10) {
        println("Receive: ${channel.receive()}, thread :${Thread.currentThread().name}")
    }
    println("Finish!")
}
