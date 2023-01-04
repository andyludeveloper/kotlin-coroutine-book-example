package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    firstFlow()
        .take(3)
        .filter { it % 2 == 0 }
        .collect { println(it) }
}
