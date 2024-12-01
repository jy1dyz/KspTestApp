package kg.study.ksptestapp.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

abstract class BaseVM<S: State, SE: SideEffect>(initialState: S) : ContainerHost<S, SE>, ViewModel() {

    override val container = container<S, SE>(initialState)


}