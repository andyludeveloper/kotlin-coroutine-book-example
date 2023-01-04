package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val flow = firstFlow()

    flow.map { it * 3 }
        .onEach { println(it) }
        .collect()
}

