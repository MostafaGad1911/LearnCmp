package mostafa.projects.learccmp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.School
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mostafa.projects.learccmp.designsystem.LearnCmpTheme
import mostafa.projects.learccmp.designsystem.components.LearnPrimaryButton
import mostafa.projects.learccmp.designsystem.components.LearnTextField
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(state: LoginUiState, onAction: (LoginAction) -> Unit) {
    Box(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(horizontal = 28.dp), contentAlignment = Alignment.Center) {
        Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
            Box(Modifier.size(68.dp).background(MaterialTheme.colorScheme.primary, RoundedCornerShape(22.dp)), contentAlignment = Alignment.Center) {
                Icon(Icons.Rounded.School, contentDescription = null, tint = Color.White, modifier = Modifier.size(34.dp))
            }
            Spacer(Modifier.height(28.dp))
            Text("Welcome back", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Text("Sign in to continue learning", color = Color(0xFF737B91), modifier = Modifier.padding(top = 8.dp, bottom = 32.dp))
            LearnTextField(state.email, { onAction(LoginAction.EmailChanged(it)) }, "Email address")
            Spacer(Modifier.height(16.dp))
            LearnTextField(state.password, { onAction(LoginAction.PasswordChanged(it)) }, "Password", PasswordVisualTransformation())
            state.error?.let { Text(it, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(top = 12.dp)) }
            state.welcome?.let { Text(it, color = Color(0xFF16845B), modifier = Modifier.padding(top = 12.dp)) }
            Spacer(Modifier.height(24.dp))
            LearnPrimaryButton("Sign in", state.isLoading) { onAction(LoginAction.Submit) }
        }
    }
}

@Preview
@Composable
private fun LoginPreview() {
    LearnCmpTheme {
        LoginScreen(LoginUiState(email = "mostafa@example.com", password = "password"), onAction = {})
    }
}
