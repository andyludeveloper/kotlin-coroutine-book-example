package com.andyludeveloper.coroutine_book_example.ch4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val ceh = CoroutineExceptionHandler { _, e -> println(e.message) }
    val scope = CoroutineScope(SupervisorJob() + ceh)

    scope.launch { // Job1
        println("job1 start")
        delay(100)
        println("job1 done")
    }.join()

    scope.launch {// Job2
        println("job2 start")
        throw Error("something wrong")
    }.join()

    scope.launch {// Job3
        println("job3 start")
        delay(300)
        println("job3 done")
    }.join()

    println("done")
}
