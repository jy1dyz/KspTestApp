package kg.study.ksptestapp.base.ui_form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kg.study.ksptestapp.data.model.Post

@Composable
fun PostCard(post: Post) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp), // Set corner radius
        colors = CardDefaults.cardColors(containerColor = Color.White), // Optional background color
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            BoldText(title = post.title)
            UsualText(title = post.body)
            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)) {
                items(post.tags) { tag ->
                    ColoredText(title = tag, color = Color.LightGray)
                    Spacer(modifier = Modifier.size(8.dp))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                TextWithIcon(
                    text = post.reactions.likes.toString(),
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Favorite
                )

                TextWithIcon(
                    text = post.reactions.dislikes.toString(),
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Face
                )

                TextWithIcon(
                    text = post.views.toString(),
                    modifier = Modifier.weight(0.6f),
                    icon = Icons.Default.Notifications
                )
            }
        }
    }
}