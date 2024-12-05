package kg.study.ksptestapp.base.ui_form

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun TextWithIcon(text: String, modifier: Modifier, icon: ImageVector) {
    Row(modifier = modifier) {
        UsualText(title = text)
        Icon(
            imageVector = icon, // Built-in Material Icon
            contentDescription = "Like icon", // Accessibility description
            tint = Color.Red, // Icon color
            modifier = Modifier
                .size(18.dp)
                .align(Alignment.CenterVertically)
        )
    }
}