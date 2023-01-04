package com.andyludeveloper.coroutine_book_example.ch9

interface Service3 {
    suspend fun getName(id: Int): String
    suspend fun saveUser(id: Int, name: String)
    suspend fun getUsers(): List<User>
}
