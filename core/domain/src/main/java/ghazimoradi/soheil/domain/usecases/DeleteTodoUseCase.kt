package ghazimoradi.soheil.domain.usecases

import ghazimoradi.soheil.core.data.TodoRepository
import ghazimoradi.soheil.core.model.Todo
import javax.inject.Inject

class DeleteTodoUseCase @Inject constructor(private val todoRepository: TodoRepository) {
    suspend operator fun invoke(todo: Todo) {
        todoRepository.deleteTodo(todoId = todo.id)
    }
}