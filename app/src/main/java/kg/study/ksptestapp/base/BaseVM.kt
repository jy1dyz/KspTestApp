package kg.study.ksptestapp.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import retrofit2.HttpException

abstract class BaseVM<S: State, SE: SideEffect>(initialState: S) : ContainerHost<S, SE>, ViewModel() {

    override val container = container<S, SE>(initialState)

    open val handler = CoroutineExceptionHandler {_, exception ->
        when (exception) {
            is HttpException -> println(exception.message())
            else -> println(exception.message)
        }
    }

}