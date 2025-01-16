package ghazimoradi.soheil.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import ghazimoradi.soheil.core.model.Todo

@Entity(tableName = TodoEntity.TABLE_NAME)
data class TodoEntity(
    val title: String,
    val description: String,
    val date: String,
    val modifyDate: String,
    val haveAlarm: Boolean,
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

    companion object {
        const val TABLE_NAME = "TodoTable"
    }
}

fun Todo.toTodoEntity(): TodoEntity {
    return TodoEntity(
        title = this.title,
        description = this.description,
        date = this.date,
        modifyDate = this.modifyDate,
        haveAlarm = this.haveAlarm
    )
}

fun TodoEntity.toTodo(): Todo {
    return Todo(
        id = this.id,
        title = this.title,
        description = this.description,
        date = this.date,
        modifyDate = this.modifyDate,
        haveAlarm = this.haveAlarm
    )
}