package kg.study.ksptestapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kg.study.ksptestapp.view.ProductsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ProductScreen.route) {
        composable(Screen.ProductScreen.route) {
            ProductsScreen()
        }
    }
}
