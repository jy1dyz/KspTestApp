package kg.study.ksptestapp.base.ui_form

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextWithIcon(text: String, modifier: Modifier) {
    IconButton(onClick = { }, modifier = modifier) {
        UsualText(title = text)
        Icon(
            imageVector = Icons.Default.Favorite, // Built-in Material Icon
            contentDescription = "Like icon", // Accessibility description
            tint = Color.Red, // Icon color
            modifier = Modifier
                .size(24.dp)
        )
    }
}