package com.andyludeveloper.coroutine_book_example.ch7

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {
    val channel = Channel<Int>(capacity = Channel.UNLIMITED)

    launch(Dispatchers.Default) {
        repeat(10) {
            println("send: $it")
            channel.send(it)
        }
        channel.close()
    }

    for (i in channel) {
        println("receive: $i")
    }
}
