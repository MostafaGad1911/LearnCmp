package mostafa.projects.learccmp.data

import io.ktor.client.HttpClient
import kotlinx.coroutines.delay
import mostafa.projects.learccmp.domain.AuthRepository
import mostafa.projects.learccmp.domain.User

class AuthRepositoryImpl(private val client: HttpClient) : AuthRepository {
    override suspend fun login(email: String, password: String): Result<User> = runCatching {
        delay(900)
        // Replace with client.post("your/login/endpoint").
        User(id = "1", name = "Mostafa", email = email)
    }
}
