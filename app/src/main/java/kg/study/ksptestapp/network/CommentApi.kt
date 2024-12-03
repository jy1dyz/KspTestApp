package kg.study.ksptestapp.network

import kg.study.ksptestapp.data.model.CommentResponse
import retrofit2.http.GET

interface CommentApi {

    @GET("comments")
    suspend fun fetchComments(): CommentResponse
}