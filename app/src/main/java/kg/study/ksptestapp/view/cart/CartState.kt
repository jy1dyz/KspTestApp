package kg.study.ksptestapp.view.cart

import kg.study.ksptestapp.base.SideEffect
import kg.study.ksptestapp.base.State
import kg.study.ksptestapp.data.model.Cart

data class CartState(
    val carts: List<Cart>? = emptyList(),
    val loading: Boolean = false
): State()

sealed class CartSideEffect: SideEffect()
