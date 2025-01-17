package ghazimoradi.soheil.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import ghazimoradi.soheil.core.model.Todo

@Entity(tableName = TodoEntity.TABLE_NAME)
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var description: String,
    var date: Long,
    var modifyDate: String,
    var haveAlarm: Boolean,
    var isDone: Boolean,
) {
    companion object {
        const val TABLE_NAME = "TodoTable"
    }
}

fun Todo.toTodoEntity(): TodoEntity {
    return TodoEntity(
        id = this.id,
        title = this.title,
        description = this.description,
        date = this.date,
        modifyDate = this.modifyDate,
        haveAlarm = this.haveAlarm,
        isDone = this.isDone
    )
}

fun TodoEntity.toTodo(): Todo {
    return Todo(
        id = this.id,
        title = this.title,
        description = this.description,
        date = this.date,
        modifyDate = this.modifyDate,
        haveAlarm = this.haveAlarm,
        isDone = this.isDone
    )
}