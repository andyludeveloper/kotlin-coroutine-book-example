package com.andyludeveloper.coroutine_book_example.ch6

import kotlinx.coroutines.*
import kotlin.random.*
import kotlin.system.*

fun main() = runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)

    println("start: ${Thread.currentThread().name}")
    val time = measureTimeMillis {
        scope.launch {
            repeat(10) {
                launch {
                    List(2000) { Random.nextInt() }
                        .filter { (it % 2) == 0 }
                        .shuffled()
                    println("($it): run in ${Thread.currentThread().name}")
                }
            }
        }.join()
    }

    println("total time: $time ms")
}
