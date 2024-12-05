package kg.study.ksptestapp.data

import kg.study.ksptestapp.data.model.Post
import kg.study.ksptestapp.network.PostApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepo @Inject constructor(
    private val api: PostApi
) {

    suspend fun fetchPosts(): List<Post> = withContext(Dispatchers.IO) {
        return@withContext api.fetchPosts().posts
    }
}