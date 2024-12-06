package kg.study.ksptestapp.base.ui_form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kg.study.ksptestapp.data.model.Recipe

@Composable
fun RecipeCard(recipe: Recipe) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp), // Set corner radius
        colors = CardDefaults.cardColors(containerColor = Color.White), // Optional background color
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row {
                CoilImage(url = recipe.image)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    TextWithIcon(
                        text = recipe.reviewCount.toString(),
                        modifier = Modifier,
                        icon = Icons.Default.Face
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    TextWithIcon(
                        text = recipe.rating.toString(),
                        modifier = Modifier,
                        icon = Icons.Default.Place
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    ColoredText(
                        title = recipe.difficulty.value,
                        color = Color.Green
                    )
                }
            }

            BoldText(title = recipe.name)
            LazyColumn {
                items(recipe.ingredients) { ingredient ->
                    ColoredText(title = ingredient, color = Color.Yellow)
                }
            }
            LazyColumn(modifier = Modifier.width(350.dp)) {
                items(recipe.instructions) { instruction ->
                    ColoredText(title = instruction, color = Color.Blue)
                }
            }
        }
    }
}