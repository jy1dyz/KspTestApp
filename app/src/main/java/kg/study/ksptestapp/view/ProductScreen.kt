package kg.study.ksptestapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kg.study.ksptestapp.data.model.Product
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun ProductsScreen() {

    val vm = hiltViewModel<ProductVM>()

    val state by vm.collectAsState()

    vm.collectSideEffect { se ->
        when (se) {
            else -> {}
        }
    }

    ProductsList(products = state.products ?: emptyList(), loading = state.loading)

}

@Composable
fun ProductsList(products: List<Product>, loading: Boolean) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (loading) Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f)),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
        LazyColumn {
            items(products) { product ->
                ProductItem(product = product)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(text = product.title ?: "", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))
        Text(text = product.description ?: "", fontFamily = FontFamily.Cursive)
    }
}
