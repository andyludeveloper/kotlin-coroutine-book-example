package com.andyludeveloper.coroutine_book_example.ch1.ch1
class MyThread: Thread() {
    private var countDown = 10

    override fun run() {
        while (countDown-- > 0) {
            println(countDown)
            yield()
        }
    }
}

fun main() {
    MyThread().start()
    println("Waiting!")
}
