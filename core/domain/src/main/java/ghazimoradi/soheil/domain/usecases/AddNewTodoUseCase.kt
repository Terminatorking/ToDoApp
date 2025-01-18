package ghazimoradi.soheil.domain.usecases

import ghazimoradi.soheil.core.data.TodoRepository
import ghazimoradi.soheil.core.model.Todo
import ghazimoradi.soheil.core.recivers.ReminderManager
import javax.inject.Inject

class AddNewTodoUseCase @Inject constructor(
    private val todoRepository: TodoRepository,
    private val reminderManager: ReminderManager,
) {
    suspend operator fun invoke(todo: Todo) {
        val todoId = todoRepository.insertTodo(todo)
        if(todo.haveAlarm){
            reminderManager.setReminder(todo.date, todoId.toInt())
        }
    }
}