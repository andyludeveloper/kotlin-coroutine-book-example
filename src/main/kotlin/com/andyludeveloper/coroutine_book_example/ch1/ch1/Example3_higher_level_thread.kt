package com.andyludeveloper.coroutine_book_example.ch1.ch1

import java.lang.Thread.*
import kotlin.concurrent.*

fun main() {
    thread {
        var countDown = 10

        while (countDown-- > 0) {
            println(countDown)
            yield()
        }
    }
    println("Waiting!")
}
