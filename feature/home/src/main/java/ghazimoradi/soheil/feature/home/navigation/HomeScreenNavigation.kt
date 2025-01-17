package ghazimoradi.soheil.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import ghazimoradi.soheil.feature.home.HomeScreen

const val homeScreenRoute = "homeScreenRoute"

fun NavGraphBuilder.homeScreen(
    paddingValues: PaddingValues,
    navigateToAddEditTodoScreen: () -> Unit
) {
    composable(
        route = homeScreenRoute,
    ) {
        HomeScreen(
            paddingValues = paddingValues,
            navigateToAddEditTodoScreen = navigateToAddEditTodoScreen
        )
    }
}

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    navigate(route = homeScreenRoute, navOptions = navOptions)
}