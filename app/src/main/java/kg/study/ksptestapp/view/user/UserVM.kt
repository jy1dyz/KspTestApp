package kg.study.ksptestapp.view.user

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.study.ksptestapp.base.BaseVM
import kg.study.ksptestapp.data.UserRepo
import kg.study.ksptestapp.data.model.Gender
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
        reduce { state.copy(loading = true) }
        val users = repo.fetchUsers()
        val hiddenNumberUsers = users.map { user ->
            if (user.gender == Gender.FEMALE) user.copy(isNumberHidden = true)
            else user
        }
        reduce { state.copy(users = hiddenNumberUsers, loading = false) }
    }

}