package kg.study.ksptestapp.network

import kg.study.ksptestapp.data.model.UserResponse
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun fetchUsers(): UserResponse
}