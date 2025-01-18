package ghazimoradi.soheil.todo.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import ghazimoradi.soheil.feature.addedittodo.navigation.addEditToDoScreen
import ghazimoradi.soheil.feature.addedittodo.navigation.navigateToAddEditToDoScreen
import ghazimoradi.soheil.feature.home.navigation.homeScreen
import ghazimoradi.soheil.feature.home.navigation.navigateToHomeScreen
import ghazimoradi.soheil.feature.splash.navigation.splashScreen
import ghazimoradi.soheil.feature.splash.navigation.splashScreenRoute

@Composable
fun ToDoNavigation(
    paddingValues: PaddingValues,
    context: Context,
    modifier: Modifier,
    navHostController: NavHostController,
    startDestination: String = splashScreenRoute,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination,
    ) {
        splashScreen(
            navigateToHomeScreen = {
                navHostController.navigateToHomeScreen(
                    navOptions = NavOptions.Builder()
                        .setPopUpTo(splashScreenRoute, inclusive = true).build()
                )
            },
        )
        homeScreen(
            paddingValues = paddingValues,
            navigateToAddTodoScreen = {
                navHostController.navigateToAddEditToDoScreen()
            },
            navigateToEditTodoScreen = {
                navHostController.navigateToAddEditToDoScreen(it)
            },
        )
        addEditToDoScreen(
            paddingValues = paddingValues, context = context,
            navigateToHomeScreen = {
                navHostController.navigateToHomeScreen()
            },
        )
    }
}