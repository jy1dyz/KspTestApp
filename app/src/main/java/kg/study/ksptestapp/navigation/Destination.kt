package kg.study.ksptestapp.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {

    @Serializable
    data object ProductsScreen: Destination

}

sealed class Screen(val route: String) {

    data object ProductScreen: Screen("ProductScreen")
    data object UserScreen: Screen("UserScreen")
}