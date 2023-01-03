package com.andyludeveloper.coroutine_book_example.ch1

fun interface Callback {
    fun invoke(value: Int)
}

class ThreadWithCallback2(private val callback: Callback) : Runnable {
    private var value = 0

    override fun run() {
        callback.invoke(++value)
    }
}

fun main() {
    val threadWithCallback = ThreadWithCallback2 { value ->
        println(value)
    }

    val thread = Thread(threadWithCallback)
    thread.start()
}
