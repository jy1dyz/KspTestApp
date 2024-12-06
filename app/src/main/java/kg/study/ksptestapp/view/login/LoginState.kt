package kg.study.ksptestapp.view.login

import kg.study.ksptestapp.base.SideEffect
import kg.study.ksptestapp.base.State
import kg.study.ksptestapp.data.model.UserAuthModel


data class LoginState(
    val userAuthModel: UserAuthModel? = null
): State()

sealed class LoginSideEffect: SideEffect()