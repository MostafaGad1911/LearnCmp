package mostafagad.learncmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import mostafagad.learncmp.navigation.Screen
import mostafagad.learncmp.presentation.screens.splash.SplashScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.Splash) {
            composable<Screen.Splash> {
                SplashScreen()
            }
        }
    }
}
