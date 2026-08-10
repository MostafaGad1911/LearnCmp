package mostafa.projects.learccmp.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinished: () -> Unit) {
    LaunchedEffect(Unit) { delay(1_500); onFinished() }
    Box(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(20.dp)) {
            Box(Modifier.size(88.dp).background(MaterialTheme.colorScheme.primary, RoundedCornerShape(28.dp)), contentAlignment = Alignment.Center) {
                Text("L", color = Color.White, fontSize = 42.sp, fontWeight = FontWeight.Bold)
            }
            Text("learnCmp", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text("Learn. Build. Grow.", color = Color(0xFF737B91))
        }
    }
}
