package com.andyludeveloper.coroutine_book_example.ch1.ch1

import java.util.concurrent.*

class InterruptableThread : Runnable {
    private var i = 0


    override fun run() {
        while (Thread.currentThread().isInterrupted) {
            i++
            TimeUnit.MILLISECONDS.sleep(100)
        }
        println("Thread has been stopped: $i")
    }
}

fun main() {
    val interruptableThread = InterruptableThread()
    val thread = Thread(interruptableThread)
    thread.start()
    TimeUnit.SECONDS.sleep(1)
    thread.interrupt()
    println("Done")
}
