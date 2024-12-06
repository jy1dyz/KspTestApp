package kg.study.ksptestapp.network

import kg.study.ksptestapp.data.model.RecipeResponse
import retrofit2.http.GET

interface RecipeApi {

    @GET("recipes")
    suspend fun fetchRecipes(): RecipeResponse
}