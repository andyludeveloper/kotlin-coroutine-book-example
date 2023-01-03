package com.andyludeveloper.coroutine_book_example.ch1

import java.util.concurrent.*

class ThreadWithException : Thread() {
    override fun run() {
        super.run()
        while (true) {
            println("Thread Start")
            TimeUnit.SECONDS.sleep(1)
            throw RuntimeException("Something happened")
        }
    }
}

fun main() {
    ThreadWithException().start()
    println("Main Thread Start")

//---    Catch Exception ---

//    val threadWithException = ThreadWithException()
//    threadWithException.uncaughtExceptionHandler =
//        Thread.UncaughtExceptionHandler { _, ex
//            -> println("Uncaught exception: $ex")
//        }
//    threadWithException.start()
//    println("Main Thread Start")
}
