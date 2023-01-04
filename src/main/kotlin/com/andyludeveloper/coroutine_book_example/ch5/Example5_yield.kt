package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val child = launch {
        try {
            println("Child coroutine start") //2-2
            delay(Long.MAX_VALUE) // 3-1
        } finally { //4-2
            println("Child coroutine is canceled")
        }
    }
    println("Parent coroutine start") // 1
    yield() //2-1
    println("Canceling child") // 3-2
    child.cancel() // 4-1
    child.join() // 5-1
    println("Parent coroutine is not canceled") //5-2
}
