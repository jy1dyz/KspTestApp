package kg.study.ksptestapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Long?,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val rating: Double,
    val tags: List<String>,
    val brand: String,
    val reviews: List<Review>,
    val images: List<String>,
    val thumbnail: String
)

@Serializable
data class Review(
    val rating: Double,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String
)

