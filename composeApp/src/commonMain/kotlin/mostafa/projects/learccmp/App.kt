package mostafa.projects.learccmp

import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import mostafa.projects.learccmp.designsystem.LearnCmpTheme
import mostafa.projects.learccmp.di.initKoin
import mostafa.projects.learccmp.domain.LoginUseCase
import mostafa.projects.learccmp.login.LoginScreen
import mostafa.projects.learccmp.login.LoginViewModel
import mostafa.projects.learccmp.splash.SplashScreen

private enum class Screen { Splash, Login }

@Composable
fun App() {
    LearnCmpTheme {
        var screen by remember { mutableStateOf(Screen.Splash) }
        when (screen) {
            Screen.Splash -> SplashScreen { screen = Screen.Login }
            Screen.Login -> {
                val loginViewModel = viewModel { LoginViewModel(initKoin().get<LoginUseCase>()) }
                val state by loginViewModel.state.collectAsStateWithLifecycle()
                LoginScreen(state, loginViewModel::onAction)
            }
        }
    }
}
