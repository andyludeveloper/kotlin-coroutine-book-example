package com.andyludeveloper.coroutine_book_example.ch9.fake

import com.andyludeveloper.coroutine_book_example.ch9.*
import kotlinx.coroutines.*

class FakeService(private val isTimeOut: Boolean = false) : Service {
    override suspend fun getName(id: Int): String {
        if (isTimeOut) {
            delay(2000)
        }
        return "done"
    }
}