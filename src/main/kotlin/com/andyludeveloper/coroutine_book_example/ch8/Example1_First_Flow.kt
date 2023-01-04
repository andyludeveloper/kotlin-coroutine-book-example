package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun firstFlow(): Flow<Int> = flow {
    repeat(10) {
        delay(100)
        emit(it)
    }
}
fun main() = runBlocking {
    firstFlow()
        .collect { println(it) }
}
