package com.andyludeveloper.coroutine_book_example.ch9.fake

import com.andyludeveloper.coroutine_book_example.ch9.*
import kotlinx.coroutines.*

class FakeService2(private val isTimeOut: Boolean = false) : Service2 {
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

    override fun getUsers(): List<User> {
        return users
    }
}
