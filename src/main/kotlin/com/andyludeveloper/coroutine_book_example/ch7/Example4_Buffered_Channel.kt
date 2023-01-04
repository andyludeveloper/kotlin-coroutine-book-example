package com.andyludeveloper.coroutine_book_example.ch7

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {
    val channel = Channel<Int>(capacity = 5)

    launch(Dispatchers.Default) {
        repeat(10) {
            println("send: $it")
            channel.send(it)
        }
        channel.close()
    }

    for (i in channel) {
        println("channel receive: $i")
    }
}
