package com.andyludeveloper.coroutine_book_example.ch1.ch1

import java.util.concurrent.*

class MyCallable : Callable<Int> {
    private var value = 0

    init {
        println("Thread init")
    }

    fun add() {
        println("add")
        value++
    }

    override fun call(): Int {
        return value
    }
}

fun main() {
    val callable = MyCallable()
    val futureTask = FutureTask(callable)
    val thread = Thread(futureTask)
    println("Start")
    thread.start()
    callable.add()
    println(futureTask.get())
}
