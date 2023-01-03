package com.andyludeveloper.coroutine_book_example.ch3

import java.util.concurrent.*

class TaskWithValue1 : Callable<Int> {
    override fun call(): Int {
        Thread.sleep(100)
        println("call 1, ${Thread.currentThread().name}")
        return 100
    }
}

class TaskWithValue2 : Callable<Int> {

    override fun call(): Int {
        Thread.sleep(200)
        println("call 2, ${Thread.currentThread().name}")
        return 200
    }
}

fun main() {
    val taskWithValue1 = TaskWithValue1()
    val taskWithValue2 = TaskWithValue2()

    val futureTask1 = FutureTask(taskWithValue1)
    val futureTask2 = FutureTask(taskWithValue2)

    val executor = Executors.newFixedThreadPool(2)
    executor.execute(futureTask1)
    executor.execute(futureTask2)

    println("Task start")
    println("Task done, result: ${futureTask1.get() + futureTask2.get()}")

    executor.shutdown()
}
