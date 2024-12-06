package kg.study.ksptestapp.data

import kg.study.ksptestapp.data.model.Recipe
import kg.study.ksptestapp.network.RecipeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeRepo @Inject constructor(
    private val api: RecipeApi
) {

    suspend fun fetchRecipes(): List<Recipe> = withContext(Dispatchers.IO) {
        return@withContext api.fetchRecipes().recipes
    }

}