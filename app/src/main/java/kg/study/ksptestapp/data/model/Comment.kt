package kg.study.ksptestapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val id: Int,
    val body: String,
    val postId: Long,
    val likes: Int,
    val user: CommentUser
)

@Serializable
data class CommentUser(
    val id: Int,
    val username: String,
    val fullName: String
)

@Serializable
data class CommentResponse(
    val comments: List<Comment>
)
