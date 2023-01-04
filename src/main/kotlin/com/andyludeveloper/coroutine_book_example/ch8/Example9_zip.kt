package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val stringFlow = listOf("a", "b", "c", "d").asFlow()

    firstFlow()
        .zip(stringFlow) { int, string -> "$int-$string" }
        .collect { println(it) }
}
