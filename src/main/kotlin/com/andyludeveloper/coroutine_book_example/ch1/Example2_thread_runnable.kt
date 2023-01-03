package com.andyludeveloper.coroutine_book_example.ch1

import java.lang.Thread.*

class MyRunnable : Runnable {
    private var countDown = 10

    override fun run() {
        while (countDown-- > 0) {
            println(countDown)
            yield()
        }
    }
}


fun main() {
    val runnable = MyRunnable()
    val thread = Thread(runnable)
    println("Waiting!")
    thread.start()
    thread.join()
}