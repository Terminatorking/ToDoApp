package ghazimoradi.soheil.core.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ghazimoradi.soheil.core.database.TodoEntity

@Dao
interface ToDoDao {
    @Insert
    suspend fun insertTodo(entity: TodoEntity)

    @Query("SELECT * FROM ${TodoEntity.TABLE_NAME}")
    suspend fun getAllTodos(): List<TodoEntity>

    @Query("delete from ${TodoEntity.TABLE_NAME} where id=:todoId")
    suspend fun deleteTodo(todoId: Int)
}