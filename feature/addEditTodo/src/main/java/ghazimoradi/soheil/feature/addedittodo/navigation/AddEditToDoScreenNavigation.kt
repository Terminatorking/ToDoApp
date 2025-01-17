package ghazimoradi.soheil.feature.addedittodo.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ghazimoradi.soheil.feature.addedittodo.AddEditToDoScreen

const val addEditToDoScreenRoute = "addEditToDoScreenRoute"
const val todoIdArg = "todoId"
const val addEditTodoScreenRouteWithArg = "addEditTodoScreenRoute/{$todoIdArg}"

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
    composable(
        route = addEditTodoScreenRouteWithArg,
        arguments = listOf(
            navArgument(todoIdArg) {
                type = NavType.IntType
            }
        )
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

fun NavController.navigateToAddEditToDoScreen(todoId: Int) {
    navigate(route = "addEditTodoScreenRoute/{$todoId}")
}