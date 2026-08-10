package mostafa.projects.learccmp

import androidx.compose.ui.window.ComposeUIViewController
import mostafa.projects.learccmp.di.initKoin

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}
