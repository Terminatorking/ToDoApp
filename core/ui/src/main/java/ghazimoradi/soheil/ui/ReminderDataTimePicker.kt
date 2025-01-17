package ghazimoradi.soheil.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun ReminderDateTimePicker(modifier: Modifier = Modifier, onDateTimeSelected: (Calendar) -> Unit) {
    val calendar = remember { Calendar.getInstance() }
    Column(modifier = modifier.fillMaxWidth()) {
        TodoDatePicker(
            initialDate = calendar,
            onDateSelected = { selectedDateCalender ->
                calendar.set(Calendar.YEAR, selectedDateCalender.get(Calendar.YEAR))
                calendar.set(Calendar.MONTH, selectedDateCalender.get(Calendar.MONTH))
                calendar.set(Calendar.DAY_OF_MONTH, selectedDateCalender.get(Calendar.DAY_OF_MONTH))
            },
        )
        Spacer(modifier = modifier.height(12.dp))
        TodoTimePicker(
            initialDate = calendar,
            onTimeSelected = { selectedTimeCalender ->
                calendar.set(Calendar.HOUR_OF_DAY, selectedTimeCalender.get(Calendar.HOUR_OF_DAY))
                calendar.set(Calendar.MINUTE, selectedTimeCalender.get(Calendar.MINUTE))
            },
        )
        onDateTimeSelected.invoke(calendar)
    }
}