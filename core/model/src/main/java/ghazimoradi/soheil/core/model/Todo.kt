package ghazimoradi.soheil.core.model

data class Todo(
    var id: Int=0,
    var title: String,
    var description: String,
    var date: String,
    var modifyDate: String,
    var haveAlarm: Boolean,
)
