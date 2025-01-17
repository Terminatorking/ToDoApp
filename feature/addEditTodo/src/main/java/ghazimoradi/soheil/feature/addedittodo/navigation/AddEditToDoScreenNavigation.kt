package ghazimoradi.soheil.feature.addedittodo.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ghazimoradi.soheil.feature.addedittodo.AddEditToDoScreen

const val addEditToDoScreenRoute = "addEditToDoScreenRoute"

fun NavGraphBuilder.addEditToDoScreen(
    paddingValues: PaddingValues,
    context: Context,
    navigateToHomeScreen: () -> Unit
) {
    composable(
        route = addEditToDoScreenRoute,
    ) {
        AddEditToDoScreen(
            paddingValues = paddingValues,
            context = context,
            navigateToHomeScreen = navigateToHomeScreen
        )
    }
}

fun NavController.navigateToAddEditToDoScreen() {
    navigate(route = addEditToDoScreenRoute)
}