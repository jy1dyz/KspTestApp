package kg.study.ksptestapp.data

import kg.study.ksptestapp.data.model.Cart
import kg.study.ksptestapp.network.CartApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CartRepo @Inject constructor(
    private val api: CartApi
) {

    suspend fun fetchCarts(): List<Cart> = withContext(Dispatchers.IO) {
        return@withContext api.fetchCarts().carts
    }
}