package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val flow = firstFlow()

    flow.onEach { println(it) }
        .map { it * 3 }
        .collect()
}
