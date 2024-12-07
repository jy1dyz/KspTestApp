package kg.study.ksptestapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Cart(
    val id: Int,
    val products: List<CartProduct>,
    val total: Double,
    val totalProducts: Int,
    val totalQuantity: Int
)

@Serializable
data class CartProduct(
    val id: Int,
    val title: String,
    val price: Double,
    val quantity: Int,
    val total: Double,
    val thumbnail: String
)

@Serializable
data class CartResponse(
    val carts: List<Cart>
)
