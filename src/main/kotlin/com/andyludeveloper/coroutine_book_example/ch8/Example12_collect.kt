package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val flow: Flow<Int> = firstFlow()

    flow.onStart { println("start") }
        .onEach { println(it) }
        .onCompletion { println("done") }
        .collect()
}
