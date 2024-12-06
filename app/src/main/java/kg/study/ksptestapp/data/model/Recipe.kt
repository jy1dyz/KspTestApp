package kg.study.ksptestapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: Int,
    val name: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val prepTimeMinutes: Int,
    val cookTimeMinutes: Int,
    val difficulty: Difficulty,
    val tags: List<String>,
    val image: String,
    val rating: Double,
    val reviewCount: Int
)

@Serializable
enum class Difficulty(val value: String) {
    EASY("Easy"),
    MEDIUM("Medium");

    companion object {
        fun fromValue(value: String): Difficulty? {
            return Difficulty.entries.find { it.value == value }
        }
    }

}

@Serializable
data class RecipeResponse(
    val recipes: List<Recipe>
)


