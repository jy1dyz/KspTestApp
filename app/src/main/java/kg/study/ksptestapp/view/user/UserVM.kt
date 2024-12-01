package kg.study.ksptestapp.view.user

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.study.ksptestapp.base.BaseVM
import kg.study.ksptestapp.data.UserRepo
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class UserVM @Inject constructor(
    private val repo: UserRepo
): BaseVM<UserState, UserSideEffect>(UserState()) {

    override val container: Container<UserState, UserSideEffect> = container(UserState()) {
        fetchUsers()
    }

    private fun fetchUsers() = intent {
        val users = repo.fetchUsers()
        reduce { state.copy(users = users, loading = false) }
    }

}