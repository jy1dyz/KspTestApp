package kg.study.ksptestapp.data.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kg.study.ksptestapp.navigation.Screen

data class ScreenItem(
    val screen: Screen,
    val title: String = screen.route
) {
    @Composable
    fun getItemColor(): Color {
        return when (screen) {
            Screen.ProductScreen -> Color.Yellow
            Screen.UserScreen -> Color.Green
            Screen.CommentScreen -> Color.Blue
            Screen.CartsScreen -> Color.LightGray
            else -> Color.Cyan
        }.copy(alpha = 0.25f)
    }
}
