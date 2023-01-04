package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        println("child, thread: ${Thread.currentThread().name}")

        withContext(Dispatchers.Default) {
            println("In withContext, thread: ${Thread.currentThread().name}")
        }
        println("Out withContext, thread: ${Thread.currentThread().name}")
    }

    println("parent, thread: ${Thread.currentThread().name}")
}
