package kg.study.ksptestapp.view.post

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import kg.study.ksptestapp.base.ui_form.PostCard
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun PostScreen() {

    val vm = hiltViewModel<PostVM>()
    val state = vm.collectAsState()

    LazyColumn {
        items(state.value.posts ?: emptyList()) { post ->
            PostCard(post)
        }
    }

}

