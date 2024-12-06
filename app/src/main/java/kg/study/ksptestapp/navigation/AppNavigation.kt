package kg.study.ksptestapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kg.study.ksptestapp.MainScreen
import kg.study.ksptestapp.view.comment.CommentScreen
import kg.study.ksptestapp.view.post.PostScreen
import kg.study.ksptestapp.view.product.ProductsScreen
import kg.study.ksptestapp.view.recipe.RecipesScreen
import kg.study.ksptestapp.view.user.UserScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MainScreen(navController)
        }

        composable(Screen.ProductScreen.route) {
            ProductsScreen(navController)
        }

        composable(Screen.UserScreen.route) {
            UserScreen()
        }

        composable(Screen.CommentScreen.route) {
            CommentScreen()
        }

        composable(Screen.PostScreen.route) {
            PostScreen()
        }

        composable(Screen.RecipesScreen.route) {
            RecipesScreen()
        }
    }
}
