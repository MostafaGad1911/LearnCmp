package mostafa.projects.learccmp.domain

data class User(val id: String, val name: String, val email: String)

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<User>
}

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<User> {
        if (email.isBlank() || password.isBlank()) return Result.failure(IllegalArgumentException("Email and password are required"))
        return repository.login(email.trim(), password)
    }
}
