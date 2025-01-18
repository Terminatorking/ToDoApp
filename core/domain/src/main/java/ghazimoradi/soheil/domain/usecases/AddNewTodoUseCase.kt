package ghazimoradi.soheil.domain.usecases

import ghazimoradi.soheil.core.data.TodoRepository
import ghazimoradi.soheil.core.model.Todo
import ghazimoradi.soheil.core.recivers.ReminderManager
import javax.inject.Inject

class AddNewTodoUseCase @Inject constructor(
    private val TodoRepository: TodoRepository,
    private val reminderManager: ReminderManager,
) {
    suspend operator fun invoke(todo: Todo) {
        val todoId = TodoRepository.insertTodo(todo)
        reminderManager.setReminder(todo.date, todoId.toInt())
    }
}