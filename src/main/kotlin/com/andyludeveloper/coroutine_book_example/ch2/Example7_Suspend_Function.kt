package com.andyludeveloper.coroutine_book_example.ch2

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delayAndShow()
    }
    println("Start")
}

private suspend fun delayAndShow() {
    delay(100)
    println("Coroutine")
}
