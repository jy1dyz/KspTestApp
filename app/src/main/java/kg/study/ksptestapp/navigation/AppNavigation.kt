package kg.study.ksptestapp.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import kg.study.ksptestapp.MainScreen
import kg.study.ksptestapp.util.AppDeepLinks
import kg.study.ksptestapp.view.cart.CartsScreen
import kg.study.ksptestapp.view.comment.CommentScreen
import kg.study.ksptestapp.view.post.PostScreen
import kg.study.ksptestapp.view.product.ProductsScreen
import kg.study.ksptestapp.view.recipe.RecipesScreen
import kg.study.ksptestapp.view.user.UserScreen

@Composable
fun AppNavigation(intent: Intent) {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MainScreen(navController)
        }

        composable(
            Screen.ProductScreen.route,
            deepLinks = listOf(navDeepLink { uriPattern = AppDeepLinks.PRODUCTS })
        ) {
            ProductsScreen()
        }

        composable(
            Screen.UserScreen.route,
            deepLinks = listOf(navDeepLink { uriPattern = AppDeepLinks.USERS })
        ) {
            UserScreen()
        }

        composable(
            Screen.CommentScreen.route,
            deepLinks = listOf(navDeepLink { uriPattern = AppDeepLinks.COMMENTS })
        ) {
            CommentScreen()
        }

        composable(
            Screen.PostScreen.route,
            deepLinks = listOf(navDeepLink { uriPattern = AppDeepLinks.POST })
        ) {
            PostScreen()
        }

        composable(
            Screen.RecipesScreen.route,
            deepLinks = listOf(navDeepLink { uriPattern = AppDeepLinks.RECIPE })
        ) {
            RecipesScreen()
        }

        composable(
            Screen.CartsScreen.route,
            deepLinks = listOf(navDeepLink { uriPattern = AppDeepLinks.CARTS })
        ) {
            CartsScreen()
        }

    }
    navController.handleDeepLink(intent)
}
