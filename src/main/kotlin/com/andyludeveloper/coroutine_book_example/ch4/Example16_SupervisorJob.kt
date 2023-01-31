package com.andyludeveloper.coroutine_book_example.ch4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val ceh = CoroutineExceptionHandler { _, e -> println(e.message) }
    val scope = CoroutineScope(ceh)

    val job = SupervisorJob()

    val parentJob = scope.launch {
        launch(job) {
            println("job1 start")
            delay(100)
            println("job1 done")
        }.join()

        launch(job) {
            println("job2 start")
            throw Error("something wrong")
        }.join()

        launch(job) {
            println("job3 start")
            delay(300)
            println("job3 done")
        }.join()
    }
    parentJob.join()

    println("done")
}
