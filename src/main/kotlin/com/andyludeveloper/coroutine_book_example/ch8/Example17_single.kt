package com.andyludeveloper.coroutine_book_example.ch8

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

data class ProgrammingLanguage(val name: String, val version: String)

fun main() = runBlocking {
    val programmingLanguage = flow {
        delay(100)
        emit(ProgrammingLanguage("Kotlin", "1.7.21"))
    }

    val value = programmingLanguage
        .map { it.name.uppercase() }
        .single()

    println(value)
}
