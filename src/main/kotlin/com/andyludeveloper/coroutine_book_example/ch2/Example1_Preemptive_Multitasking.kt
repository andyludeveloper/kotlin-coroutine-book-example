package com.andyludeveloper.coroutine_book_example.ch2

import java.util.concurrent.*
import kotlin.random.*

class ThreadPriority(
    private var id: Int, private var priority: Int
) : Runnable {

    private var countDown = 3
    private var d: Double = 0.0

    override fun toString(): String = "($id) ${Thread.currentThread()} : $countDown"

    override fun run() {
        println("($id) run: priority: $priority")
        Thread.currentThread().priority = priority
        while (true) {
            repeat(1000) {
                d += List(5000) { Random.nextDouble() * Random.nextDouble() }
                    .shuffled()
                    .maxOf { value -> value }

                if (it % 100 == 0) {
                    Thread.yield()
                }
                println(this)
                if (--countDown == 0) {
                    return
                }
            }
        }
    }
}

fun main() {
    val exec = Executors.newCachedThreadPool()
    repeat(3) {
        exec.execute(ThreadPriority(0, Thread.MIN_PRIORITY))
    }
    exec.execute(ThreadPriority(1, Thread.MAX_PRIORITY))
    exec.shutdown()
}