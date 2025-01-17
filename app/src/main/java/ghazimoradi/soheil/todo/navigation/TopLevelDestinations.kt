package ghazimoradi.soheil.todo.navigation

import ghazimoradi.soheil.feature.addedittodo.navigation.addEditToDoScreenRoute
import ghazimoradi.soheil.feature.home.navigation.homeScreenRoute
import ghazimoradi.soheil.feature.splash.navigation.splashScreenRoute

enum class TopLevelDestinations(val route: String) {
    HOME_SCREEN(homeScreenRoute),
    ADD_EDIT_TODO_SCREEN(addEditToDoScreenRoute),
    SPLASHSCREEN(splashScreenRoute)
}