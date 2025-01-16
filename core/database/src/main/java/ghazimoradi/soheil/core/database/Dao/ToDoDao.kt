package ghazimoradi.soheil.core.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ghazimoradi.soheil.core.database.TodoEntity

@Dao
interface ToDoDao {
    @Insert
    suspend fun insertTask(entity: TodoEntity)

    @Query("SELECT * FROM ${TodoEntity.TABLE_NAME}")
    suspend fun getAllTasks(): List<TodoEntity>

    @Delete
    suspend fun deleteTask(entity: TodoEntity)
}