package ghazimoradi.soheil.domain

import ghazimoradi.soheil.core.data.TodoRepository
import ghazimoradi.soheil.core.model.Todo
import javax.inject.Inject

class AddNewTodoUseCase @Inject constructor(
    private val TodoRepository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo) {
        TodoRepository.insertTask(todo)
    }
}