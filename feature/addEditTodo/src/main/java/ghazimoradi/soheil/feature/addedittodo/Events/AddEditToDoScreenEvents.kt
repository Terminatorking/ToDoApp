package ghazimoradi.soheil.feature.addedittodo.Events

import ghazimoradi.soheil.core.model.Todo

sealed class AddEditToDoScreenEvents {
    data class AddToDo(val todo: Todo) : AddEditToDoScreenEvents()
    data class EditToDo(val todo: Todo) : AddEditToDoScreenEvents()
}