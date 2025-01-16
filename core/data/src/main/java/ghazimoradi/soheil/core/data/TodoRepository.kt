package ghazimoradi.soheil.core.data

import ghazimoradi.soheil.core.model.Todo

interface TodoRepository {
    suspend fun insertTask(todo: Todo)
    suspend fun getAllTask(): List<Todo>
}