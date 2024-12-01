package kg.study.ksptestapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Long?,
    val title: String?,
    val description: String?,
    val category: String?,
    val price: Double?,
    val rating: Double?
)
