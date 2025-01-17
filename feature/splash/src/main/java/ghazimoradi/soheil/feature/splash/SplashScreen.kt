package ghazimoradi.soheil.feature.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.hilt.navigation.compose.hiltViewModel
import ghazimoradi.soheil.core.designSystem.components.TodoDisplayLarge
import ghazimoradi.soheil.core.designSystem.theme.*

@Composable
fun SplashScreen(
    navigateToHomeScreen: () -> Unit,
    viewModel: SplashScreenViewModel = hiltViewModel()
) {
    val navigateState = viewModel.navigateToHomeScreen.collectAsState().value
    if (navigateState) {
        navigateToHomeScreen.invoke()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Iceberg,
                        Turquoise,
                    )
                )
            )
    ) {
        TodoDisplayLarge(
            text = "ToDo",
            color = Color.White,
            shadow = Shadow(BlackAlphaHalf)
        )
    }
}
