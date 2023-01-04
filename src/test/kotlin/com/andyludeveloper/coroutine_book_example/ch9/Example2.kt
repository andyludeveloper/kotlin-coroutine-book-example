package com.andyludeveloper.coroutine_book_example.ch9

import com.andyludeveloper.coroutine_book_example.ch9.fake.*
import kotlinx.coroutines.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

internal class Example2 {
    private var userRepo: UserRepo = UserRepo()

    @Test
    internal fun `fetchUserName success should return done`() = runBlocking {
        assertEquals("done", userRepo.fetchUserName(FakeService()))
    }

    @Test
    internal fun `fetchUserName timeout should return fail`() = runBlocking {
        assertEquals("fail", userRepo.fetchUserName(FakeService(isTimeOut = true)))
    }
}