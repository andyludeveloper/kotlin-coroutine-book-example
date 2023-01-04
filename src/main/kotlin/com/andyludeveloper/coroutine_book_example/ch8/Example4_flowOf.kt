package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.*

suspend fun randomNumberUntil(until: Int): Int {
    delay(100)
    return Random.nextInt(until)
}

fun main() = runBlocking {
    flowOf(
        randomNumberUntil(10),
        randomNumberUntil(10),
        randomNumberUntil(10)
    ).collect { println(it) }
}
