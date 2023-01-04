package com.andyludeveloper.coroutine_book_example.ch9

interface Service2 {
    suspend fun getName(id: Int): String
    suspend fun saveUser(id: Int, name: String)
    fun getUsers(): List<User>
}
