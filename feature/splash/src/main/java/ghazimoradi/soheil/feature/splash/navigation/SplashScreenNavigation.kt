package ghazimoradi.soheil.feature.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ghazimoradi.soheil.feature.splash.SplashScreen

const val splashScreenRoute = "splashScreenRoute"

fun NavGraphBuilder.splashScreen(navigateToHomeScreen: () -> Unit) {
    composable(
        route = splashScreenRoute,
    ) {
        SplashScreen(navigateToHomeScreen = navigateToHomeScreen)
    }
}
