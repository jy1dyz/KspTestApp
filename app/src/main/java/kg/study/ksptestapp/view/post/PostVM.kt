package kg.study.ksptestapp.view.post

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.study.ksptestapp.base.BaseVM
import kg.study.ksptestapp.data.PostRepo
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class PostVM @Inject constructor(
    private val repo: PostRepo
): BaseVM<PostState, PostSideEffect>(PostState()) {

    override val container: Container<PostState, PostSideEffect> = container(PostState()) {
        fetchPosts()
    }

    private fun fetchPosts() = intent {
        reduce { state.copy(loading = true) }
        val posts = repo.fetchPosts()
        reduce { state.copy(posts = posts, loading = false) }
    }

}