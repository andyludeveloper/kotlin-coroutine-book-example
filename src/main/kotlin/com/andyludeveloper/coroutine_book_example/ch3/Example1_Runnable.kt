package com.andyludeveloper.coroutine_book_example.ch3

import kotlinx.coroutines.*
class LaunchRunnable : Runnable {
    override fun run() {
        Thread.sleep(100)
        println("Coroutine")
    }
}

fun main() {
    val runnable = LaunchRunnable()
    val thread = Thread(runnable)
    println("Start")
    thread.start()
}