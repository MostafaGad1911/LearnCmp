package mostafa.projects.learccmp.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LearnTextField(value: String, onValueChange: (String) -> Unit, label: String, visualTransformation: VisualTransformation = VisualTransformation.None) {
    OutlinedTextField(value = value, onValueChange = onValueChange, label = { Text(label) }, singleLine = true, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp), visualTransformation = visualTransformation)
}

@Composable
fun LearnPrimaryButton(text: String, loading: Boolean, onClick: () -> Unit) {
    Button(onClick = onClick, enabled = !loading, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(16.dp)) {
        if (loading) CircularProgressIndicator(color = Color.White, strokeWidth = 2.dp) else Text(text)
    }
}
