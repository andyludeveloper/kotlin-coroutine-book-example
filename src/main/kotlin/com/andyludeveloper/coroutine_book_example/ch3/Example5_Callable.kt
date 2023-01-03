package com.andyludeveloper.coroutine_book_example.ch3

import java.util.concurrent.*

class MyCallable : Callable<Boolean> {
    private var result: Boolean

    init {
        result = false
    }

    override fun call(): Boolean {
        Thread.sleep(500)
        result = true
        return this.result
    }
}

fun main() {
    val myCallable = MyCallable()
    val futureTask = FutureTask(myCallable)
    val thread = Thread(futureTask)
    thread.start()

    println("Thread start")
    println("task done, result: " + futureTask.get())
}