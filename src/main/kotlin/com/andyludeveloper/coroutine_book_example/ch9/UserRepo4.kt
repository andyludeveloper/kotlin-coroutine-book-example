package com.andyludeveloper.coroutine_book_example.ch9

import kotlinx.coroutines.*

class UserRepo4(
    private val service: Service3,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
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
        service.saveUser(id, name)
    }

    suspend fun getUsers(): List<User> {
        return service.getUsers()
    }

}
