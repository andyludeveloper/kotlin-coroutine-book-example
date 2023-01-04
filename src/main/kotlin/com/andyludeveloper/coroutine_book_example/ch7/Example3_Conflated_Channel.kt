package com.andyludeveloper.coroutine_book_example.ch7

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {
    val channel = Channel<Int>(capacity = Channel.CONFLATED)
    launch(Dispatchers.Default) {
        repeat(10) {
            channel.send(it)
        }

        delay(100)
        channel.send(1000)
    }

    delay(200)
    println(channel.receive())

    println("Finish!")
}
