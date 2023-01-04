package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*

fun main() = runBlocking {
    firstFlow().collect { println(it) }
    println("---")
    firstFlow().collect { println(it) }
}
