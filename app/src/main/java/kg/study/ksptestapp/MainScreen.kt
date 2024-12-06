package kg.study.ksptestapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kg.study.ksptestapp.base.ui_form.ScreenCard
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MainScreen(navController: NavController) {
    val vm = hiltViewModel<MainVM>()
    val state = vm.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Number of columns in the grid
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp), // Padding around the grid
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between columns
        verticalArrangement = Arrangement.spacedBy(8.dp) // Space between rows
    ) {
        items(state.value.screens) { screen ->
            ScreenCard(screen = screen, navController)
        }
    }

}