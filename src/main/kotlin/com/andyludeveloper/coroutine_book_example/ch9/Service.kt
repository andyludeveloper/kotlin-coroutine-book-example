package com.andyludeveloper.coroutine_book_example.ch9

interface Service {
    suspend fun getName(id: Int): String

}