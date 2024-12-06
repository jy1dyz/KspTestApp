package kg.study.ksptestapp.view.post

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import kg.study.ksptestapp.base.ui_form.LoadingScreen
import kg.study.ksptestapp.base.ui_form.PostCard
import kg.study.ksptestapp.data.model.Post
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun PostScreen() {

    val vm = hiltViewModel<PostVM>()
    val state by vm.collectAsState()

    when (state.loading) {
        true -> LoadingScreen()
        else -> PostList(posts = state.posts ?: emptyList())
    }


}

@Composable
fun PostList(posts: List<Post>) {
    LazyColumn {
        items(posts ?: emptyList()) { post ->
            PostCard(post)
        }
    }
}

