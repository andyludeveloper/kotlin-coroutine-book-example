package com.andyludeveloper.coroutine_book_example.ch1.ch1

import java.util.concurrent.*
import kotlin.concurrent.*

fun main() {
    val outerThread = thread { //outer thread
        var i = 0

        thread { //inner therad
            println("InnerThread run!")
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100)
            }
            println("InnerThread done!")
        }

        while (Thread.currentThread().isInterrupted) {
            i++
            TimeUnit.MILLISECONDS.sleep(10)
        }

        println("Thread has been stopped: $i")
    }

    TimeUnit.MILLISECONDS.sleep(200)
    outerThread.interrupt()
}
