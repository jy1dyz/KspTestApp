package kg.study.ksptestapp.view.user

import kg.study.ksptestapp.base.SideEffect
import kg.study.ksptestapp.base.State
import kg.study.ksptestapp.data.model.User

data class UserState(
    val loading: Boolean = false,
    val users: List<User>? = emptyList()
): State()

sealed class UserSideEffect: SideEffect() {
    data class Toast(val text: String)
}
