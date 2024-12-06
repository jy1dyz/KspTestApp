package kg.study.ksptestapp.base.ui_form

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kg.study.ksptestapp.navigation.Screen

@Composable
fun ScreenCard(screen: Screen, navController: NavController) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Set corner radius
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.size(100.dp),
        onClick = {
            navController.navigate(screen.route)
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            BoldText(title = screen.route)
        }
    }

}