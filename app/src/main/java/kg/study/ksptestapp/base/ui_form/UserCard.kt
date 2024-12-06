package kg.study.ksptestapp.base.ui_form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kg.study.ksptestapp.data.model.User

@Composable
fun UserCard(user: User) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Set corner radius
        colors = CardDefaults.cardColors(containerColor = Color.White), // Optional background color
        modifier = Modifier
            .fillMaxWidth().padding(12.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            BoldText(title = "${user.firstName} ${user.lastName}")
            ColoredText(title = user.email, color = Color.Yellow)
            Row(modifier = Modifier.fillMaxWidth()) {
                BoldText(title = user.age.toString(), modifier = Modifier.weight(1f))
                ColoredText(title = user.gender.name, color = Color.DarkGray, modifier = Modifier.weight(2f))
                ColoredText(title = user.bloodGroup, color = Color.Red)
            }
            UsualText(title = user.university)
            UsualText(title = user.phone)
            AsyncCoilImage(url = user.image)
        }
    }
}