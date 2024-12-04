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
import kg.study.ksptestapp.base.ui_form.UserCard
import kg.study.ksptestapp.base.ui_form.UsualCardOfThree
import kg.study.ksptestapp.data.model.User
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun UserScreen() {

    val vm = hiltViewModel<UserVM>()
    val state = vm.collectAsState()

    UsersList(state = state.value)
}

@Composable
fun UsersList(state: UserState) {
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