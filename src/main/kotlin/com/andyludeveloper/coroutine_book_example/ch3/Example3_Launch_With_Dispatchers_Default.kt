package com.andyludeveloper.coroutine_book_example.ch3

import kotlinx.coroutines.*
import kotlin.random.*
fun main() = runBlocking {

    repeat(10) {
        launch(Dispatchers.Default) {
            repeat(10_00) {
                val overflow = listOf(Long.MAX_VALUE)
                overflow.map { Long.MAX_VALUE * Random.nextInt() }
            }
            println("Run in background thread: ${Thread.currentThread().name}")
        }
    }
    println("Start coroutine, ${Thread.currentThread().name}")
}