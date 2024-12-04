package kg.study.ksptestapp.base.ui_form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kg.study.ksptestapp.data.model.CommentUser

@Composable
fun UsualCard(title: String, subtitle: String) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Set corner radius
        colors = CardDefaults.cardColors(containerColor = Color.White), // Optional background color
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            BoldText(title = title)
            UsualText(title = subtitle)
        }
    }
}

@Composable
fun UsualCardOfThree(title: String, subtitle: String, coloredText: String) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Set corner radius
        colors = CardDefaults.cardColors(containerColor = Color.White), // Optional background color
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            BoldText(title = title)
            UsualText(title = subtitle)
            ColoredText(title = coloredText, color = Color.Green)
        }
    }
}

@Composable
fun CommentCard(body: String, author: CommentUser, likes: Int) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp), // Set corner radius
        colors = CardDefaults.cardColors(containerColor = Color.White), // Optional background color
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(5f)
            ) {
                ColoredText(title = author.username, color = Color.Yellow)
                BoldText(title = author.fullName)
                UsualText(title = body)
            }
            Row(modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(0.7f)) {
                UsualText(title = likes.toString(), modifier = Modifier
                    .padding(2.dp)
                    .align(Alignment.CenterVertically))
                Icon(
                    imageVector = Icons.Default.Favorite, // Built-in Material Icon
                    contentDescription = "Like icon", // Accessibility description
                    tint = Color.Red, // Icon color
                    modifier = Modifier
                        .size(18.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}
