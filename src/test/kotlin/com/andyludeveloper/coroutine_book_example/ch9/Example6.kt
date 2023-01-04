import com.andyludeveloper.coroutine_book_example.ch9.*
import com.andyludeveloper.coroutine_book_example.ch9.fake.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

@OptIn(ExperimentalCoroutinesApi::class)
internal class Example6 {

    @Test
    internal fun `getUsers() should return 2 when add 2 users by using UnconfinedTestDispatcher`() = runTest {
        val unconfinedTestDispatcher = UnconfinedTestDispatcher(testScheduler)
        val userRepo = UserRepo4(FakeService3(), unconfinedTestDispatcher)

        launch(unconfinedTestDispatcher) { userRepo.saveUser(1, "Andy") }

        launch(unconfinedTestDispatcher) { userRepo.saveUser(2, "Alex") }

        assertEquals(2, userRepo.getUsers().size)
    }

}
