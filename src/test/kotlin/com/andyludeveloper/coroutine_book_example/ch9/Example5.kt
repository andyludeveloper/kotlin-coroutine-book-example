import com.andyludeveloper.coroutine_book_example.ch9.*
import com.andyludeveloper.coroutine_book_example.ch9.fake.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
@OptIn(ExperimentalCoroutinesApi::class)
internal class Example5 {
    private lateinit var userRepo: UserRepo4

    private val dispatcher: TestDispatcher = StandardTestDispatcher()

    @BeforeEach
    internal fun setUp() {
        userRepo = UserRepo4(FakeService3(), dispatcher)
    }

    @Test
    internal fun `getUsers() should return 2 when add 2 users`() = runTest {

        launch { userRepo.saveUser(1, "Andy") }
        launch { userRepo.saveUser(2, "Alex") }

        assertEquals(2, userRepo.getUsers().size)
    }

}
