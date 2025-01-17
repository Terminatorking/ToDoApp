package ghazimoradi.soheil.feature.addedittodo.states

sealed class AddEditToDoScreenStates (
    val mTodoTitle: String,
    val mTodoDescription: String,
    val mTodoDate: String,
    val mTodoReminder: Boolean
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
}