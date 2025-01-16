package ghazimoradi.soheil.core.data

import ghazimoradi.soheil.core.database.Dao.ToDoDao
import ghazimoradi.soheil.core.database.toTodo
import ghazimoradi.soheil.core.database.toTodoEntity
import ghazimoradi.soheil.core.model.Todo
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(private val dao: ToDoDao) : TodoRepository {
    override suspend fun insertTask(todo: Todo) {
        dao.insertTask(entity = todo.toTodoEntity())
    }

    override suspend fun getAllTask(): List<Todo> {
        return dao.getAllTasks().map { entities ->
            entities.toTodo()
        }
    }
}