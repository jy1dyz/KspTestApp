package kg.study.ksptestapp

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.study.ksptestapp.base.BaseVM
import kg.study.ksptestapp.base.SideEffect
import kg.study.ksptestapp.base.State
import kg.study.ksptestapp.navigation.Screen
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(): BaseVM<MainState, MainSideEffect>(MainState()) {

    override val container: Container<MainState, MainSideEffect> =
        container(MainState()) {
            getAllScreens()
        }

    private fun getAllScreens() = intent {
        val screens = listOf(
            Screen.UserScreen,
            Screen.CommentScreen,
            Screen.PostScreen,
            Screen.ProductScreen,
            Screen.RecipesScreen
        )
        reduce { state.copy(screens = screens) }
    }
}

data class MainState(
    val screens: List<Screen> = emptyList()
) : State()

sealed class MainSideEffect : SideEffect()

