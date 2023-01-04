package com.andyludeveloper.coroutine_book_example.ch9

import com.andyludeveloper.coroutine_book_example.ch9.fake.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

@OptIn(ExperimentalCoroutinesApi::class)
internal class Example4_2 {
    lateinit var userRepo: UserRepo3

    @DisplayName("saveUser")
    @Nested
    inner class SaveUser {
        private val dispatcher: TestDispatcher = StandardTestDispatcher()

        @BeforeEach
        internal fun setUp() {
            userRepo = UserRepo3(FakeService2(), dispatcher)
        }

        @Test
        internal fun `add 1 user should return users size 1`() = runTest {
            userRepo.saveUser(1, "Andy")
            assertEquals(1, userRepo.getUsers().size)
        }

        @Test
        internal fun `add 1 user should return users size is equal to 1`() = runTest(dispatcher){
            userRepo.saveUser(1, "Andy")
            assertEquals(1, userRepo.getUsers().size)
        }
        @Test
        internal fun `add 1 user should return users size is equal to 1 by using test dispatcher`() = runTest {
            val dispatcher: TestDispatcher = StandardTestDispatcher(testScheduler)

            userRepo = UserRepo3(FakeService2(), dispatcher)
            userRepo.saveUser(1, "Andy")

            assertEquals(1, userRepo.getUsers().size)
        }

    }
}
