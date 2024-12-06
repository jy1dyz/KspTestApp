package kg.study.ksptestapp.view.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kg.study.ksptestapp.base.ui_form.ProductCard
import kg.study.ksptestapp.data.model.Product
import kg.study.ksptestapp.util.showToast
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun ProductsScreen(navController: NavController) {

    val vm = hiltViewModel<ProductVM>()
    val state by vm.collectAsState()
    val context = LocalContext.current

    vm.collectSideEffect { se ->
        when (se) {
            is ProductSideEffect.Toast -> showToast(context, se.message)
        }
    }

    ProductsList(products = state.products ?: emptyList(), loading = state.loading, navController)

}

@Composable
fun ProductsList(products: List<Product>, loading: Boolean, navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (loading) Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
        LazyColumn {
            items(products) { product ->
                ProductItem(product = product, navController)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable {}
    ) {
        ProductCard(product)
    }
}
