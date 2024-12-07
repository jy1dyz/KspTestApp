package kg.study.ksptestapp.network

import kg.study.ksptestapp.data.model.CartResponse
import retrofit2.http.GET

interface CartApi {

    @GET("carts")
    suspend fun fetchCarts(): CartResponse
}