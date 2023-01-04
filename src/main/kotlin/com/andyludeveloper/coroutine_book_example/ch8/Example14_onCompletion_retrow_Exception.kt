package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun names(): Flow<String> = flow {
    emit("Andy")
    emit("Aaron")
    emit("Jax")
    throw Error("something wrong")
    emit("Cody")
}

fun main() = runBlocking {
    val flow: Flow<String> = names()

    flow.onEach { println(it) }
        .onCompletion {
            it?.run {
                throw Error("rethrow error")
            }
        }.catch { println(it.message) }
        .collect()
}
