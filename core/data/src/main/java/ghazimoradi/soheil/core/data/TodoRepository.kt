package ghazimoradi.soheil.core.data

import ghazimoradi.soheil.core.model.Todo

interface TodoRepository {
    suspend fun getTodoByID(todoId: Int): Todo
    suspend fun updateTodo(todo: Todo)
    suspend fun insertTodo(todo: Todo):Long
    suspend fun deleteTodo(todoId: Int)
    suspend fun getAllTodos(): List<Todo>
}