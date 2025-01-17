package ghazimoradi.soheil.domain

import ghazimoradi.soheil.core.data.TodoRepository
import ghazimoradi.soheil.core.model.Todo
import javax.inject.Inject

class GetDoneTodosUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(): List<Todo> {
        return todoRepository.getAllTask().filter {
            it.isDone
        }
    }
}