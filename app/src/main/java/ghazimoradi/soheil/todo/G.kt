package ghazimoradi.soheil.todo

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import dagger.hilt.android.HiltAndroidApp
import ghazimoradi.soheil.common.NotificationConstants.TodoNotification

@HiltAndroidApp
class G : Application() {
    override fun onCreate() {
        super.onCreate()
        createTodoAlarmNotificationChannel()
    }

    private fun createTodoAlarmNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Todo reminders"
            val description = "todo aram reminders"
            val priority = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel =
                NotificationChannel(
                    TodoNotification.CHANNEL_ID,
                    name,
                    priority
                ).apply {
                    this.description = description
                }
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}