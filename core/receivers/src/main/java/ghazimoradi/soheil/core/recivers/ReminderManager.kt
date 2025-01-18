package ghazimoradi.soheil.core.recivers

import android.app.AlarmManager
import android.app.PendingIntent.*
import android.content.Context
import android.content.Intent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ReminderManager @Inject constructor(@ApplicationContext private val context: Context) {
    fun setReminder(time: Long, todoId: Int) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, ToDoReminderReceiver::class.java).apply {
            putExtra(TODO_ID_RECEIVER_KEY, todoId)
        }
        val pendingIntent = getBroadcast(
            context,
            0,
            intent,
            FLAG_UPDATE_CURRENT or FLAG_IMMUTABLE
        )
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, time, pendingIntent)
    }
}