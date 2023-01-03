package com.andyludeveloper.coroutine_book_example.ch3

import kotlin.concurrent.*

fun main() {
    thread{
        Thread.sleep(100)
        println("Coroutine")
    }
    println("Start")
}
