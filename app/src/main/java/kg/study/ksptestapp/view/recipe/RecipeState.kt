package kg.study.ksptestapp.view.recipe

import kg.study.ksptestapp.base.SideEffect
import kg.study.ksptestapp.base.State
import kg.study.ksptestapp.data.model.Recipe

data class RecipeState(
    val recipes: List<Recipe>? = emptyList(),
    val loading: Boolean = false
): State()

sealed class RecipeSideEffect: SideEffect()
