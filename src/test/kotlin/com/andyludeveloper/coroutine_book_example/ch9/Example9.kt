import com.andyludeveloper.coroutine_book_example.ch9.*
import com.andyludeveloper.coroutine_book_example.ch9.fake.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

@OptIn(ExperimentalCoroutinesApi::class)
internal class Example9 {

    @Test
    internal fun `getUsers() should return 2 when add 2 users`() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        val userRepo = UserRepo4(FakeService3(), testDispatcher)

        launch(testDispatcher) { userRepo.saveUser(1, "Andy") }

        launch(testDispatcher) { userRepo.saveUser(2, "Alex") }

        runCurrent() // <- 加入此行
        assertEquals(2, userRepo.getUsers().size)

    }
}
