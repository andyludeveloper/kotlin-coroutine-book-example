package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val flow = firstFlow()

    val value = flow.fold(1) { acc, value ->
        println("acc: $acc, value: $value")
        acc + value*value
    }
    println(value)
}
