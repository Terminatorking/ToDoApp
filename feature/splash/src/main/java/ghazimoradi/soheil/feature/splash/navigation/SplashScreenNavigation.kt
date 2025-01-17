package ghazimoradi.soheil.feature.splash.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ghazimoradi.soheil.feature.splash.SplashScreen

const val splashScreenRoute = "splashScreenRoute"

fun NavGraphBuilder.splashScreen() {

    composable(
        route = splashScreenRoute,
    ) {
        SplashScreen()
    }
}

fun NavController.navigateToSplashScreen() {
    navigate(route = splashScreenRoute)
}