package kg.study.ksptestapp.base.ui_form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kg.study.ksptestapp.data.model.Cart

@Composable
fun CartCard(cart: Cart) {
    LazyRow {
        items(cart.products) { product ->
            Card(
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Set corner radius
                colors = CardDefaults.cardColors(containerColor = Color.White), // Optional background color
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    CoilImage(url = product.thumbnail)
                    BoldText(title = product.title)
                    ColoredText(title = product.price.toString(), color = Color.Red)
                }
            }
        }
    }
}