package kg.study.ksptestapp.base.ui_form

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kg.study.ksptestapp.data.model.Product

@Composable
fun ProductCard(product: Product) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp), // Set corner radius
        colors = CardDefaults.cardColors(containerColor = Color.White), // Optional background color
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(product.images) { image ->
                    AsyncCoilImage(url = image)
                    Spacer(modifier = Modifier.size(8.dp))
                }
            }
            BoldText(title = product.title)
            UsualText(title = product.description)
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                items(product.tags) { tag ->
                    ColoredText(title = tag, color = Color.LightGray)
                    Spacer(modifier = Modifier.size(8.dp))
                }
            }
            ColoredText(title = product.category, color = Color.Blue)
//            AsyncCoilImage(url = product.thumbnail)
        }
    }
}