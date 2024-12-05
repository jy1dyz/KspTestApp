package kg.study.ksptestapp.view.post

import kg.study.ksptestapp.base.SideEffect
import kg.study.ksptestapp.base.State
import kg.study.ksptestapp.data.model.Post

data class PostState(
    val posts: List<Post>? = emptyList(),
    val loading: Boolean = false
): State()


sealed class PostSideEffect: SideEffect()
