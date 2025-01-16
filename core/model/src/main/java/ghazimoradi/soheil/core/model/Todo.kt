package ghazimoradi.soheil.core.model

data class Todo(
    val id: Int=0,
    val title: String,
    val description: String,
    val date: String,
    val modifyDate: String,
    val haveAlarm: Boolean,
)
