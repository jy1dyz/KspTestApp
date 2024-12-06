package kg.study.ksptestapp.view.login

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.study.ksptestapp.base.BaseVM
import kg.study.ksptestapp.data.AuthRepo
import kg.study.ksptestapp.data.UserRepo
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor(
    private val repo: AuthRepo,
    private val userRepo: UserRepo
): BaseVM<LoginState, LoginSideEffect>(LoginState()) {

    override val container: Container<LoginState, LoginSideEffect> =
        container(LoginState()) {
            login()
        }

    private fun login() = intent {
        val user = userRepo.fetchUsers()[0]
        val username = user.username
        val password = user.password
        val authModel = repo.login(username, password)
        reduce { state.copy(userAuthModel = authModel) }
    }
}