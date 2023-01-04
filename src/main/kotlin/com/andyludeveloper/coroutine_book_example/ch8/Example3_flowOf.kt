package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.*

suspend fun sendValue(): Int {
    delay(100)
    return Random.nextInt()
}

fun main() = runBlocking {
    flowOf(sendValue())
        .collect { println(it) }
}
