package com.andyludeveloper.coroutine_book_example.ch3

import kotlinx.coroutines.*
import kotlin.random.*

fun main() = runBlocking {
    val randomNumber = async(Dispatchers.Default) {
        println("Generate random number, Thread: ${Thread.currentThread().name} ")
        listOf(Long.MAX_VALUE)
            .map { Long.MAX_VALUE / Random.nextInt() }
            .shuffled()
            .first()
    }
    println("Result is ${randomNumber.await()}, Thread: ${Thread.currentThread().name}")
}