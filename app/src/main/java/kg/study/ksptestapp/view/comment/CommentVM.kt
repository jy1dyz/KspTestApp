package kg.study.ksptestapp.view.comment

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.study.ksptestapp.base.BaseVM
import kg.study.ksptestapp.data.CommentRepo
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CommentVM @Inject constructor(
    private val repo: CommentRepo
): BaseVM<CommentState, CommentSideEffect>(CommentState()) {

    override val container: Container<CommentState, CommentSideEffect> =
        container(CommentState()) {
            fetchComments()
        }

    private fun fetchComments() = intent {
        val comments = repo.fetchComments()
        reduce { state.copy(comments = comments, loading = false) }
    }
}