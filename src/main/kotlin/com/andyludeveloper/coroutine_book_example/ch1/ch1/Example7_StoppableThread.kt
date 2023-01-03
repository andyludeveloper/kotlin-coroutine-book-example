package com.andyludeveloper.coroutine_book_example.ch1.ch1

import java.util.concurrent.*

class StoppableThread : Runnable {
    var isRunning: Boolean = true
    private var i = 0

    override fun run() {
        while (isRunning) {
            i++
            TimeUnit.MILLISECONDS.sleep(100)
        }
        println("Thread has been stopped: $i")
    }
}

fun main() {
    val stoppableThread = StoppableThread()
    val thread = Thread(stoppableThread)
    thread.start()
    TimeUnit.SECONDS.sleep(1)
    stoppableThread.isRunning = false
    println("Done")
}
