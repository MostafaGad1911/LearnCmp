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
    val isLoading: Boolean = false,
    val error: String? = null,
    val welcome: String? = null,
)

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
            is LoginAction.EmailChanged -> _state.update { it.copy(email = action.value, error = null) }
            is LoginAction.PasswordChanged -> _state.update { it.copy(password = action.value, error = null) }
            LoginAction.Submit -> submit()
        }
    }

    private fun submit() = viewModelScope.launch {
        val current = state.value
        _state.update { it.copy(isLoading = true, error = null, welcome = null) }
        login(current.email, current.password)
            .onSuccess { user -> _state.update { it.copy(isLoading = false, welcome = "Welcome, ${user.name}") } }
            .onFailure { error -> _state.update { it.copy(isLoading = false, error = error.message ?: "Login failed") } }
    }
}
