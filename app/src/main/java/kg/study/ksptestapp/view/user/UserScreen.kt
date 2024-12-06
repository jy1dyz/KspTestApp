package kg.study.ksptestapp.view.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kg.study.ksptestapp.base.ui_form.AsyncCoilImage
import kg.study.ksptestapp.base.ui_form.BoldText
import kg.study.ksptestapp.base.ui_form.LoadingScreen
import kg.study.ksptestapp.base.ui_form.UserCard
import kg.study.ksptestapp.data.model.User
import kg.study.ksptestapp.data.model.UserAuthModel
import kg.study.ksptestapp.view.login.LoginVM
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun UserScreen() {

    val loginVM = hiltViewModel<LoginVM>()
    val vm = hiltViewModel<UserVM>()
    val state by vm.collectAsState()
    val loginState by loginVM.collectAsState()

    when (state.loading) {
        true -> LoadingScreen()
        else -> loginState.userAuthModel?.let { UsersList(users = state.users ?: emptyList(), it) }
    }
}

@Composable
fun UsersList(users: List<User>, authModel: UserAuthModel) {
    LazyColumn {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                BoldText(title = authModel.username ?: "")
                BoldText(title = authModel.email ?: "")
                AsyncCoilImage(authModel.image ?: "")
            }
        }
        items(users) { user ->
            UserItem(user = user)
        }
    }
}

@Composable
fun UserItem(user: User) {
    UserCard(user)
}