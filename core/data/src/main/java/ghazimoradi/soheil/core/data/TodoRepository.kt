package ghazimoradi.soheil.core.data

import ghazimoradi.soheil.core.model.Todo

interface TodoRepository {
    suspend fun insertTodo(todo: Todo)
    suspend fun deleteTodo(todoId: Int)
    suspend fun getAllTodos(): List<Todo>
}