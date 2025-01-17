package ghazimoradi.soheil.feature.home.states

import ghazimoradi.soheil.core.model.Todo

sealed class HomeScreenStates {
    data object Loading : HomeScreenStates()
    data class Success(val todoList: List<Todo>, val doneTodoList: List<Todo>) : HomeScreenStates()
}