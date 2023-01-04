package com.andyludeveloper.coroutine_book_example.ch5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val jobs = mutableListOf<Job>()
    val ceh = CoroutineExceptionHandler{ _, e -> println(e.message) }
    val coroutineScope = CoroutineScope(ceh)

    repeat(10) {
        jobs.add(coroutineScope.launch {
            delay(100L * it)
            println("job: $it")
            if (it == 5) throw Error("Something incorrect")
        })
    }
    jobs.joinAll()
    println("done")
}
