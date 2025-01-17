package ghazimoradi.soheil.ui

import android.app.TimePickerDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar

@Composable
fun TodoTimePicker(
    initialDate: Calendar = Calendar.getInstance(),
    onTimeSelected: (Calendar) -> Unit
) {
    val context = LocalContext.current
    var showDialog by remember {
        mutableStateOf(true)
    }
    if (showDialog) {
        TimePickerDialog(
            context,
            { _, hour, minute ->
                val selectedTime = Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, hour)
                    set(Calendar.MINUTE, minute)
                }
                onTimeSelected.invoke(selectedTime)
                showDialog = false
            },
            initialDate.get(Calendar.HOUR_OF_DAY),
            initialDate.get(Calendar.MINUTE),
            true
        ).show()
    }
}