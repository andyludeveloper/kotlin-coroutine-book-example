package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val flow: Flow<Int> = firstFlow()

    flow.map {
        println("map: $it, ${Thread.currentThread().name}")
        it * 3
    }.flowOn(Dispatchers.Default)
        .onEach { println("onEach: $it, ${Thread.currentThread().name}") }
        .onCompletion { println("done, ${Thread.currentThread().name}") }
        .collect()
}
