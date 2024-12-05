package kg.study.ksptestapp.network

import kg.study.ksptestapp.data.model.PostResponse
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun fetchPosts(): PostResponse
}