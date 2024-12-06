package kg.study.ksptestapp.data

import kg.study.ksptestapp.data.model.UserAuthModel
import kg.study.ksptestapp.network.AuthApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepo @Inject constructor(
    private val api: AuthApi
) {

    suspend fun login(username: String, password: String): UserAuthModel =
        withContext(Dispatchers.IO) {
            return@withContext api.login(username, password)
        }
}