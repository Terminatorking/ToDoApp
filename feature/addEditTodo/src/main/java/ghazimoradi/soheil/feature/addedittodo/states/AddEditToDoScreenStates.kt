package ghazimoradi.soheil.feature.addedittodo.states

import ghazimoradi.soheil.core.model.Todo

sealed class AddEditToDoScreenStates(
    val mTodoTitle: String = "",
    val mTodoDescription: String = "",
    val mTodoDate: String = "",
    val mTodoReminder: Boolean = false
) {
    data class Empty(
        val todoTitle: String = "",
        val todoDescription: String = "",
        val todoDate: String = "",
        val todoReminder: Boolean = false
    ) : AddEditToDoScreenStates(
        mTodoTitle = todoTitle,
        mTodoDescription = todoDescription,
        mTodoDate = todoDate,
        mTodoReminder = todoReminder
    )

    data class Edit(val todo: Todo) : AddEditToDoScreenStates()
}