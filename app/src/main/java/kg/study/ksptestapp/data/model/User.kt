package kg.study.ksptestapp.data.model

import kotlinx.serialization.Serializable

data class UserResponse(
    val users: List<User>
)

@Serializable
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val age: Int,
    val gender: Gender,
    val phone: String,
    val username: String,
    val password: String,
    val image: String,
    val bloodGroup: String,
    val city: String,
    val state: String,
    val country: String,
    val university: String,
    val bank: Bank
)

@Serializable
enum class Gender(val value: String) {
    FEMALE("female"),
    MALE("male");

    companion object {
        fun fromValue(value: String): Gender? {
            return entries.find { it.value == value }
        }
    }
}

@Serializable
data class Bank(
    val cardExpire: String,
    val cardNumber: String,
    val iban: String
)

enum class Role(val value: String) {
    ADMIN("admin")
}

data class UserAuthModel(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val image: String,
    val accessToken: String,
    val refreshToken: String
)


