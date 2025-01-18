package ghazimoradi.soheil.core.recivers

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import dagger.hilt.android.AndroidEntryPoint
import ghazimoradi.soheil.common.NotificationConstants.TodoNotification
import ghazimoradi.soheil.core.data.TodoRepository
import ghazimoradi.soheil.ui.R.drawable.ic_alarm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject


const val TODO_ID_RECEIVER_KEY = "TODO_ID_RECEIVER_KEY"

@AndroidEntryPoint
class ToDoReminderReceiver : BroadcastReceiver() {
    @Inject
    lateinit var todoRepository: TodoRepository
    override fun onReceive(context: Context?, intent: Intent?) {
        val todoId = intent?.getIntExtra(TODO_ID_RECEIVER_KEY, -1)
        if (todoId != -1 && todoId != null) {
            CoroutineScope(IO).launch {
                val todo = todoRepository.getTodoByID(todoId)
                val notification =
                    NotificationCompat.Builder(context!!, TodoNotification.CHANNEL_ID)
                        .setSmallIcon(ic_alarm)
                        .setContentTitle(todo.title)
                        .setContentText(todo.description)
                        .setPriority(NotificationCompat.PRIORITY_HIGH).setAutoCancel(true).build()
                with(NotificationManagerCompat.from(context)) {
                    if (ActivityCompat.checkSelfPermission(
                            context,
                            Manifest.permission.POST_NOTIFICATIONS
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        notify(1, notification)
                    }
                }
            }
        }
    }
}