package ghazimoradi.soheil.domain.usecases

import ghazimoradi.soheil.core.data.TodoRepository
import ghazimoradi.soheil.core.model.Todo
import javax.inject.Inject

class GetTodoByIdUseCase @Inject constructor(private val todoRepository: TodoRepository) {
    suspend operator fun invoke(todoId: Int): Todo {
        return todoRepository.getTodoByID(todoId = todoId)
    }
}