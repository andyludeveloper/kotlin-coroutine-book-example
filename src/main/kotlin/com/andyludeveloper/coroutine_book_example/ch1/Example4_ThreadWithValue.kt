package com.andyludeveloper.coroutine_book_example.ch1

class ThreadWithValue : Runnable {
    private var value = 0

    override fun run() {
        println("run")
        value++
    }

    fun getValue(): Int {
        return value
    }
}

fun main() {
    val threadWithValue = ThreadWithValue()
    val thread = Thread(threadWithValue)
    thread.start()
    //thread.join()
    println(threadWithValue.getValue())
}
