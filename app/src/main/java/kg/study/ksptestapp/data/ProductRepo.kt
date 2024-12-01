package kg.study.ksptestapp.data

import kg.study.ksptestapp.data.model.Product
import kg.study.ksptestapp.network.ProductApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ProductRepo @Inject constructor(private val api: ProductApi) {

    suspend fun fetchProducts(): List<Product> = withContext(Dispatchers.IO) {
        return@withContext api.fetchProducts().products
    }

}