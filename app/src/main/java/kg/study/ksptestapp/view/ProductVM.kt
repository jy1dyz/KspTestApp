package kg.study.ksptestapp.view

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.study.ksptestapp.base.BaseVM
import kg.study.ksptestapp.data.ProductRepo
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ProductVM @Inject constructor(
    private val productRepo: ProductRepo
) : BaseVM<ProductsState, ProductSideEffect>(ProductsState()) {

    override val container: Container<ProductsState, ProductSideEffect> =
        container(ProductsState()) {
            fetchProducts()
        }

    private fun fetchProducts() = intent {
        viewModelScope.launch(handler) {
            val products = productRepo.fetchProducts()
            reduce {
                state.copy(loading = false, products = products)
            }
        }
    }


}