package ghazimoradi.soheil.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ghazimoradi.soheil.feature.home.HomeScreen

const val homeScreenRoute = "homeScreenRoute"

fun NavGraphBuilder.homeScreen(paddingValues: PaddingValues) {

    composable(
        route = homeScreenRoute,
    ) {
        HomeScreen(paddingValues)
    }
}

fun NavController.navigateToHomeScreen() {
    navigate(route = homeScreenRoute)
}