package kg.study.ksptestapp.view.recipe

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.study.ksptestapp.base.BaseVM
import kg.study.ksptestapp.data.RecipeRepo
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class RecipeVM @Inject constructor(
    private val repo: RecipeRepo
): BaseVM<RecipeState, RecipeSideEffect>(RecipeState()) {

    override val container: Container<RecipeState, RecipeSideEffect> =
        container(RecipeState()) {
            fetchRecipes()
        }

    private fun fetchRecipes() = intent {
        reduce { state.copy(loading = true) }
        val recipes = repo.fetchRecipes()
        reduce {
            state.copy(recipes = recipes, loading = false)
        }
    }
}