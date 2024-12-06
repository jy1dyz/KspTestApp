package kg.study.ksptestapp.view.comment

import kg.study.ksptestapp.base.SideEffect
import kg.study.ksptestapp.base.State
import kg.study.ksptestapp.data.model.Comment

data class CommentState(
    val comments: List<Comment>? = emptyList(),
    val loading: Boolean = false
): State()

sealed class CommentSideEffect: SideEffect()
