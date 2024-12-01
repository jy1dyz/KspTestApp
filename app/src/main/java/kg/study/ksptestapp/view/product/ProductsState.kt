package kg.study.ksptestapp.view.product

import kg.study.ksptestapp.base.SideEffect
import kg.study.ksptestapp.base.State
import kg.study.ksptestapp.data.model.Product

data class ProductsState(
    val products: List<Product>? = null,
    val loading: Boolean = true,
    val error: String? = null
): State()


sealed class ProductSideEffect: SideEffect() {
    data class Toast(val message: String): ProductSideEffect()
}
