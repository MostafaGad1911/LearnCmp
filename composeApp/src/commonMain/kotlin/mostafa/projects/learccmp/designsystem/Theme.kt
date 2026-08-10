package mostafa.projects.learccmp.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LearnBlue = Color(0xFF3157D5)
val LearnBackground = Color(0xFFF7F8FC)

@Composable
fun LearnCmpTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = LearnBlue,
            background = LearnBackground,
            surface = Color.White,
        ),
        typography = Typography(),
        content = content,
    )
}
