package ghazimoradi.soheil.core.data

import ghazimoradi.soheil.core.database.Dao.ToDoDao
import ghazimoradi.soheil.core.database.toTodo
import ghazimoradi.soheil.core.database.toTodoEntity
import ghazimoradi.soheil.core.model.Todo
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(private val dao: ToDoDao) : TodoRepository {
    override suspend fun getTodoByID(todoId: Int): Todo {
        return dao.getTodoByID(todoId = todoId).toTodo()
    }

    override suspend fun updateTodo(todo: Todo) {
        dao.updateTodo(entity = todo.toTodoEntity())
    }

    override suspend fun insertTodo(todo: Todo): Long {
       return dao.insertTodo(entity = todo.toTodoEntity())
    }

    override suspend fun deleteTodo(todoId: Int) {
        dao.deleteTodo(todoId = todoId)
    }

    override suspend fun getAllTodos(): List<Todo> {
        return dao.getAllTodos().map { entities ->
            entities.toTodo()
        }
    }
}