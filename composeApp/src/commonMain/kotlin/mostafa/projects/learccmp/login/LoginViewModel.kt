package mostafa.projects.learccmp.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mostafa.projects.learccmp.domain.LoginUseCase

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val welcome: String? = null,
) {
    val isFormValid: Boolean
        get() = email.isNotBlank() &&
            password.isNotBlank() &&
            emailError == null &&
            passwordError == null
}

sealed interface LoginAction {
    data class EmailChanged(val value: String) : LoginAction
    data class PasswordChanged(val value: String) : LoginAction
    data object Submit : LoginAction
}

class LoginViewModel(private val login: LoginUseCase) : ViewModel() {
    private val _state = MutableStateFlow(LoginUiState())
    val state: StateFlow<LoginUiState> = _state

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.EmailChanged -> _state.update {
                it.copy(
                    email = action.value,
                    emailError = validateEmail(action.value),
                    error = null,
                    welcome = null,
                )
            }
            is LoginAction.PasswordChanged -> _state.update {
                it.copy(
                    password = action.value,
                    passwordError = validatePassword(action.value),
                    error = null,
                    welcome = null,
                )
            }
            LoginAction.Submit -> submit()
        }
    }

    private fun submit() = viewModelScope.launch {
        val current = state.value
        val emailError = validateEmail(current.email)
        val passwordError = validatePassword(current.password)
        if (emailError != null || passwordError != null) {
            _state.update { it.copy(emailError = emailError, passwordError = passwordError) }
            return@launch
        }
        _state.update { it.copy(isLoading = true, error = null, welcome = null) }
        login(current.email, current.password)
            .onSuccess { user -> _state.update { it.copy(isLoading = false, welcome = "Welcome, ${user.name}") } }
            .onFailure { error -> _state.update { it.copy(isLoading = false, error = error.message ?: "Login failed") } }
    }

    private fun validateEmail(value: String): String? = when {
        value.isBlank() -> "Email is required"
        !EMAIL_REGEX.matches(value.trim()) -> "Enter a valid email address"
        else -> null
    }

    private fun validatePassword(value: String): String? = when {
        value.isBlank() -> "Password is required"
        value.length < 8 -> "Use at least 8 characters"
        value.none(Char::isUpperCase) -> "Add at least one uppercase letter"
        value.none(Char::isLowerCase) -> "Add at least one lowercase letter"
        value.none(Char::isDigit) -> "Add at least one number"
        value.all(Char::isLetterOrDigit) -> "Add at least one special character"
        else -> null
    }

    private companion object {
        val EMAIL_REGEX = Regex("^[A-Za-z0-9.!#\$%&'*+/=?^_\u0060{|}~-]+@[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?(?:\\.[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?)+$")
    }
}
