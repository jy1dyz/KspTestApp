package kg.study.ksptestapp.view.comment

import android.icu.text.CaseMap.Title
import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import kg.study.ksptestapp.base.ui_form.ClickableCard
import kg.study.ksptestapp.base.ui_form.CommentCard
import kg.study.ksptestapp.base.ui_form.LoadingScreen
import kg.study.ksptestapp.base.ui_form.UsualCard
import kg.study.ksptestapp.data.model.Comment
import kg.study.ksptestapp.data.model.CommentUser
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CommentScreen() {
    val vm = hiltViewModel<CommentVM>()

    val state by vm.collectAsState()
    when (state.loading) {
        true -> LoadingScreen()
        else -> CommentsList(
            comments = state.comments ?: emptyList()
        )
    }
}

@Composable
fun CommentsList(comments: List<Comment>) {
    var isDialogOpen by remember { mutableStateOf(false) }

    LazyColumn {
        item {
            ClickableCard(title = "Open Dialog", subtitle = "") {
                isDialogOpen = true
            }
        }
        items(comments) { comment ->
            CommentItem(comment = comment)
        }
    }

    if (isDialogOpen) {
        Dialog(onDismissRequest = { isDialogOpen = false }) {
            UsualCard(title = "Dialog title", subtitle = "Dialog subtitle")
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