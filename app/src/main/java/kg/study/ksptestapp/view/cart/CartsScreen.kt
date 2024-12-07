package kg.study.ksptestapp.view.cart

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import kg.study.ksptestapp.base.ui_form.CartCard
import kg.study.ksptestapp.base.ui_form.LoadingScreen
import kg.study.ksptestapp.data.model.Cart
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CartsScreen() {

    val vm = hiltViewModel<CartVM>()
    val state by vm.collectAsState()

    when (state.loading) {
        true -> LoadingScreen()
        else -> CartsList(carts = state.carts ?: emptyList())
    }
}

@Composable
fun CartsList(carts: List<Cart>) {
    LazyColumn {
        items(carts) { cart ->
            CartCard(cart = cart)
        }
    }
}