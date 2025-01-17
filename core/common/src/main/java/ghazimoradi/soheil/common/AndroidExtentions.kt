package ghazimoradi.soheil.common

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun Calendar.formatTimestamp(): String {
    val format = SimpleDateFormat("HH:mm | yyyy/MM/dd", Locale.getDefault())
    return format.format(time)
}
