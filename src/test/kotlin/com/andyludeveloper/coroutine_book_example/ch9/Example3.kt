package com.andyludeveloper.coroutine_book_example.ch9

import com.andyludeveloper.coroutine_book_example.ch9.fake.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

@OptIn(ExperimentalCoroutinesApi::class)
internal class Example3 {
    private var userRepo: UserRepo = UserRepo()

    @Test
    internal fun `fetchUserName success should return done`() = runTest {
        assertEquals("done", userRepo.fetchUserName(FakeService()))
    }

    @Test
    internal fun `fetchUserName timeout should return fail`() = runTest {
        assertEquals("fail", userRepo.fetchUserName(FakeService(isTimeOut = true)))
    }
}
