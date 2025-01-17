package ghazimoradi.soheil.ui

import android.app.DatePickerDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar

@Composable
fun TodoDatePicker(
    initialDate: Calendar = Calendar.getInstance(),
    onDateSelected: (Calendar) -> Unit
) {
    val context = LocalContext.current
    var showDialog by remember {
        mutableStateOf(true)
    }

    if (showDialog) {
        DatePickerDialog(
            context,
            { _, year, month, day ->
                val selectedCalender = Calendar.getInstance().apply {
                    set(year, month, day)
                }
                onDateSelected.invoke(selectedCalender)
                showDialog = false
            },
            initialDate.get(Calendar.YEAR),
            initialDate.get(Calendar.MONTH),
            initialDate.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
}