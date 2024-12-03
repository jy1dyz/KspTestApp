package kg.study.ksptestapp.data

import kg.study.ksptestapp.data.model.Comment
import kg.study.ksptestapp.network.CommentApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CommentRepo @Inject constructor(
    private val api: CommentApi
) {

    suspend fun fetchComments(): List<Comment> = withContext(Dispatchers.IO) {
        return@withContext api.fetchComments().comments
    }
}