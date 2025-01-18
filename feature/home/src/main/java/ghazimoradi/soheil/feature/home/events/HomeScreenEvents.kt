package ghazimoradi.soheil.feature.home.events

import ghazimoradi.soheil.core.model.Todo

sealed class HomeScreenEvents {
    data class Delete(val todo: Todo) : HomeScreenEvents()
    data object Update : HomeScreenEvents()
    data class Done(val todo: Todo) : HomeScreenEvents()
}