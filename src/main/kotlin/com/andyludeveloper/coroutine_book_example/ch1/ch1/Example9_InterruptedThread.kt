package com.andyludeveloper.coroutine_book_example.ch1.ch1

import java.util.concurrent.*

class Money {
    private var i: Int = 0

    @Synchronized
    fun add(): Int {
        ++i
        return i
    }
}

class SynchronizedBlocked(private val money: Money) : Runnable {
    override fun run() {
        try {
            while (true) {
                val value = money.add()
                println("current value $value ${Thread.currentThread().name}")
                TimeUnit.MILLISECONDS.sleep(100)
            }
        } catch (e: InterruptedException) {
            println("Interrupted ${Thread.currentThread().name}")
        }
        println("Thread has been stopped: ${Thread.currentThread().name}")
    }
}

fun main() {
    val money = Money()

    val synchronizedBlocked = SynchronizedBlocked(money)
    val synchronizedBlocked2 = SynchronizedBlocked(money)

    val thread = Thread(synchronizedBlocked)
    val thread2 = Thread(synchronizedBlocked2)

    thread.start()
    thread2.start()

    TimeUnit.MILLISECONDS.sleep(200)

    thread.interrupt()
    thread2.interrupt()

    println("Done")
}
