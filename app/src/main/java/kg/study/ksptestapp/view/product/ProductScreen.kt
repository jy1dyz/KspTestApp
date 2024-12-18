package kg.study.ksptestapp.view.product

import android.app.Activity
import android.view.WindowManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kg.study.ksptestapp.base.ui_form.LoadingScreen
import kg.study.ksptestapp.base.ui_form.ProductCard
import kg.study.ksptestapp.data.model.Product
import kg.study.ksptestapp.util.showToast
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun ProductsScreen() {

    val vm = hiltViewModel<ProductVM>()
    val state by vm.collectAsState()
    val context = LocalContext.current
    val activity = LocalContext.current as? Activity

    /** запрет на скриншот только для этого экрана */
    DisposableEffect(Unit) {
        activity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        onDispose {
            activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
        }
    }

    vm.collectSideEffect { se ->
        when (se) {
            is ProductSideEffect.Toast -> showToast(context, se.message)
        }
    }

    when (state.loading) {
        true -> LoadingScreen()
        else -> ProductsList(products = state.products ?: emptyList())
    }

}

@Composable
fun ProductsList(products: List<Product>) {
    LazyColumn {
        items(products) { product ->
            ProductItem(product = product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable {}
    ) {
        ProductCard(product)
    }
}
