package kg.study.ksptestapp.network

import kg.study.ksptestapp.data.model.ProductsResponse
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun fetchProducts(): ProductsResponse
}