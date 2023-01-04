package com.andyludeveloper.coroutine_book_example.ch9.fake

import com.andyludeveloper.coroutine_book_example.ch9.*
import kotlinx.coroutines.*

class FakeService3(private val isTimeOut: Boolean = false) : Service3 {
    private val users = mutableListOf<User>()
    override suspend fun getName(id: Int): String {
        if (isTimeOut) {
            delay(2000)
        }
        return "done"
    }

    override suspend fun saveUser(id: Int, name: String) {
        delay(100)
        users.add(User(id, name))
    }

    override suspend fun getUsers(): List<User> {
        delay(100)
        return users
    }
}
