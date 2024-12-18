package kg.study.ksptestapp.base.ui_form

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

@Composable
fun CoilImage(url: String) {
    Image(
        painter = rememberAsyncImagePainter(url), // Image URL
        contentDescription = "downloaded Image",
        modifier = Modifier
            .size(128.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Color.White)// Adjust size as needed
    )
}

@Composable
fun AsyncCoilImage(url: String) {
    AsyncImage(
        model = url, // Image URL
        contentDescription = "Example Image",
        modifier = Modifier.size(128.dp) // Adjust size as needed
    )
}