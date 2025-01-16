package ghazimoradi.soheil.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

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