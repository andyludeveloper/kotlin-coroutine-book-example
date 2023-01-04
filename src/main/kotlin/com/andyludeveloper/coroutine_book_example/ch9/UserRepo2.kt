package com.andyludeveloper.coroutine_book_example.ch9

import kotlinx.coroutines.*

class UserRepo2(private val service: Service2) {
    suspend fun fetchUserName(id: Int = 0): String {
        return try {
            val name = withTimeout(1000) {
                service.getName(id)
            }
            name
        } catch (e: TimeoutCancellationException) {
            "fail"
        }
    }

    suspend fun saveUser(id: Int, name: String) {
        withContext(Dispatchers.Default) {
            service.saveUser(id, name)
        }
    }

    fun getUsers(): List<User>{
        return service.getUsers()
    }
}
