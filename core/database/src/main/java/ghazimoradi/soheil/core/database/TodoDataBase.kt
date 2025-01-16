package ghazimoradi.soheil.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ghazimoradi.soheil.core.database.Dao.ToDoDao

@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDataBase : RoomDatabase() {
    abstract fun getTodoDao(): ToDoDao

    companion object {
        val DATABASE_NAME = "TodoDataBase"
    }
}