package ghazimoradi.soheil.domain.usecases

import ghazimoradi.soheil.core.data.TodoRepository
import ghazimoradi.soheil.core.model.Todo
import javax.inject.Inject

class GetDoneTodosUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(): List<Todo> {
        return todoRepository.getAllTodos().filter {
            it.isDone
        }
    }
}