package kg.study.ksptestapp.view.comment

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
import kg.study.ksptestapp.base.ui_form.CommentCard
import kg.study.ksptestapp.data.model.Comment
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CommentScreen() {
    val vm = hiltViewModel<CommentVM>()

    val state = vm.collectAsState()
    CommentsList(comments = state.value.comments ?: emptyList(), loading = state.value.loading)
}

@Composable
fun CommentsList(comments: List<Comment>, loading: Boolean) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (loading) Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
        LazyColumn {
            items(comments) { comment ->
                CommentItem(comment = comment)
            }
        }
    }
}

@Composable
fun CommentItem(comment: Comment) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        CommentCard(body = comment.body, author = comment.user, likes = comment.likes)
    }
}