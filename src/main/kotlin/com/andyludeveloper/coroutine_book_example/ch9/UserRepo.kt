package com.andyludeveloper.coroutine_book_example.ch9

import kotlinx.coroutines.*

class UserRepo {
    suspend fun fetchUserName(service: Service, id: Int = 0): String {
        return try {
            val name = withTimeout(1000) {
                service.getName(id)
            }
            name
        } catch (e: TimeoutCancellationException) {
            "fail"
        }
    }

}
