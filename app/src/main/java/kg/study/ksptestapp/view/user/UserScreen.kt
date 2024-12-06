package kg.study.ksptestapp.view.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kg.study.ksptestapp.base.ui_form.AsyncCoilImage
import kg.study.ksptestapp.base.ui_form.BoldText
import kg.study.ksptestapp.base.ui_form.UserCard
import kg.study.ksptestapp.data.model.User
import kg.study.ksptestapp.view.login.LoginState
import kg.study.ksptestapp.view.login.LoginVM
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun UserScreen() {

    val loginVM = hiltViewModel<LoginVM>()
    val vm = hiltViewModel<UserVM>()
    val state = vm.collectAsState()
    val loginState = loginVM.collectAsState()

    UsersList(state = state.value, loginState = loginState.value)
}

@Composable
fun UsersList(state: UserState, loginState: LoginState) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.loading) Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
        val users = state.users ?: emptyList()
        LazyColumn {
            item {
                val authModel = loginState.userAuthModel
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)) {
                    BoldText(title = authModel?.username ?: "")
                    BoldText(title = authModel?.email ?: "")
                    AsyncCoilImage(authModel?.image ?: "")
                }
            }
            items(users) { user ->
                UserItem(user = user)
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        UserCard(user)
    }
}