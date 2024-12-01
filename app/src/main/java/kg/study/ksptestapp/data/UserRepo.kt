package kg.study.ksptestapp.data

import kg.study.ksptestapp.data.model.User
import kg.study.ksptestapp.network.UserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val api: UserApi
) {

    suspend fun fetchUsers(): List<User> = withContext(Dispatchers.IO) {
        return@withContext api.fetchUsers().users
    }
}