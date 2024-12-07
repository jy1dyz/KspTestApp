package kg.study.ksptestapp.view.cart

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.study.ksptestapp.base.BaseVM
import kg.study.ksptestapp.data.CartRepo
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CartVM @Inject constructor(
    private val repo: CartRepo
) : BaseVM<CartState, CartSideEffect>(CartState()) {

    override val container: Container<CartState, CartSideEffect> =
        container(CartState()) {
            fetchCarts()
        }

    private fun fetchCarts() = intent {
        reduce { state.copy(loading = true) }
        val carts = repo.fetchCarts()
        reduce { state.copy(carts = carts, loading = false) }
    }

}