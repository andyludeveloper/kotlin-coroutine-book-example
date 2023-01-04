package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val ints = listOf<Int>(1, 2, 3, 4, 5)
    ints.asFlow().collect { println(it) }
}
