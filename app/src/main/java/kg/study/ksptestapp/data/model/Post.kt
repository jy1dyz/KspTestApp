package kg.study.ksptestapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val tags: List<String>,
    val reactions: Reaction,
    val views: Int,
    val userId: Int
)

@Serializable
data class Reaction(
    val likes: Int,
    val dislikes: Int
)

@Serializable
data class PostResponse(
    val posts: List<Post>
)

