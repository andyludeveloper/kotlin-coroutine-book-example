package com.andyludeveloper.coroutine_book_example.ch9

import com.andyludeveloper.coroutine_book_example.ch9.fake.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

@OptIn(ExperimentalCoroutinesApi::class)
internal class Example4 {
    lateinit var userRepo: UserRepo2

    @DisplayName("saveUser")
    @Nested
    inner class SaveUser {

        @BeforeEach
        internal fun setUp() {
            userRepo = UserRepo2(FakeService2())
        }

        @Test
        internal fun `add 1 user should return users size 1`() = runTest {
            userRepo.saveUser(1, "Andy")
            assertEquals(1, userRepo.getUsers().size)
        }
    }
}
