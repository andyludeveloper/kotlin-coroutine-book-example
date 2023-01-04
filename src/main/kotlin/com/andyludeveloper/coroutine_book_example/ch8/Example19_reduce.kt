package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val flow = firstFlow()

    val value = flow.reduce { acc, value ->
        println("acc: $acc, value: $value")
        acc + value
    }
    println("sum: $value")
}
