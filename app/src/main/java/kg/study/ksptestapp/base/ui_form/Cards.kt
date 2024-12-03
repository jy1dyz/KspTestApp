package kg.study.ksptestapp.base.ui_form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UsualCard(title: String, subtitle: String) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Set corner radius
        colors = CardDefaults.cardColors(containerColor = Color.White), // Optional background color
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            BoldText(title = title)
            UsualText(title = subtitle)
        }
    }
}

@Composable
fun UsualCardOfThree(title: String, subtitle: String, coloredText: String) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Set corner radius
        colors = CardDefaults.cardColors(containerColor = Color.White), // Optional background color
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            BoldText(title = title)
            UsualText(title = subtitle)
            ColoredText(title = coloredText, color = Color.Green)
        }
    }
}