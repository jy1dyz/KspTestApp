package kg.study.ksptestapp.view.recipe

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import kg.study.ksptestapp.base.ui_form.RecipeCard
import kg.study.ksptestapp.data.model.Recipe
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun RecipesScreen() {

    val vm = hiltViewModel<RecipeVM>()
    val state = vm.collectAsState()

    RecipesList(recipes = state.value.recipes ?: emptyList())
}

@Composable
fun RecipesList(recipes: List<Recipe>) {
    LazyRow {
        items(recipes) { recipe ->
            RecipeCard(recipe = recipe)
        }
    }
}


