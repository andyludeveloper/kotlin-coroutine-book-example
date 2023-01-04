package com.andyludeveloper.coroutine_book_example.ch4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val ceh = CoroutineExceptionHandler {_, e -> println(e.message) }
    val scope = CoroutineScope(ceh)

    val parentJob = scope.launch {
        supervisorScope {
            val job1 = launch {
                println("job1 start")
                delay(100)
                println("job1 done")
            }

            val job2 = launch {
                println("job2 start")
                throw Error("something wrong")
            }

            val job3 = launch {
                println("job3 start")
                delay(300)
                println("job3 done")
            }
        }
    }
    parentJob.join()
    println("done")
}
