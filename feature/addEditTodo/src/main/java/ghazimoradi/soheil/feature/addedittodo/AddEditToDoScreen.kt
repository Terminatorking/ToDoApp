package ghazimoradi.soheil.feature.addedittodo

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Shapes
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ghazimoradi.soheil.common.formatTimestamp
import ghazimoradi.soheil.core.designSystem.components.TodoBodyMedium
import ghazimoradi.soheil.core.designSystem.components.TodoBodySmall
import ghazimoradi.soheil.core.designSystem.components.TodoTextFieldLabelMedium
import ghazimoradi.soheil.core.designSystem.theme.Black
import ghazimoradi.soheil.core.designSystem.theme.BlackAlpha4f
import ghazimoradi.soheil.core.designSystem.theme.Cultured
import ghazimoradi.soheil.core.designSystem.theme.Iceberg
import ghazimoradi.soheil.core.designSystem.theme.Turquoise
import ghazimoradi.soheil.core.designSystem.theme.White
import ghazimoradi.soheil.core.model.Todo
import ghazimoradi.soheil.feature.addedittodo.Events.AddEditToDoScreenEvents
import ghazimoradi.soheil.feature.addedittodo.states.AddEditToDoScreenStates
import ghazimoradi.soheil.ui.ReminderDateTimePicker
import java.util.Calendar

@Composable
fun AddEditToDoScreen(
    context: Context,
    paddingValues: PaddingValues,
    viewModel: AddEditToDoScreenViewModel = hiltViewModel(),
    navigateToHomeScreen: () -> Unit
) {
    var uiState = viewModel.uiState.collectAsState()
    var showDateTimePicker by remember {
        mutableStateOf(false)
    }
    var todoReminder by remember {
        mutableStateOf<Calendar>(Calendar.getInstance())
    }
    var todoTitleValue by remember {
        mutableStateOf(
            when (uiState.value) {
                is AddEditToDoScreenStates.Edit -> (uiState.value as AddEditToDoScreenStates.Edit).todo.title
                is AddEditToDoScreenStates.Empty -> uiState.value.mTodoTitle
            }
        )
    }
    var descriptionValue by remember {
        mutableStateOf(
            when (uiState.value) {
                is AddEditToDoScreenStates.Edit -> (uiState.value as AddEditToDoScreenStates.Edit).todo.description
                is AddEditToDoScreenStates.Empty -> uiState.value.mTodoDescription
            }
        )
    }
    var dateValue by remember {
        mutableStateOf(
            when (uiState.value) {
                is AddEditToDoScreenStates.Edit -> Calendar.getInstance().apply {
                    timeInMillis = (uiState.value as AddEditToDoScreenStates.Edit).todo.date
                }.formatTimestamp()

                is AddEditToDoScreenStates.Empty -> Calendar.getInstance().formatTimestamp()
            }
        )
    }
    var checkValue by remember {
        mutableStateOf(
            when (uiState.value) {
                is AddEditToDoScreenStates.Edit -> (uiState.value as AddEditToDoScreenStates.Edit).todo.haveAlarm
                is AddEditToDoScreenStates.Empty -> uiState.value.mTodoReminder
            }
        )
    }
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(horizontal = 15.dp)
            .background(color = Cultured)
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            LaunchedEffect(uiState.value) {
                if (uiState.value is AddEditToDoScreenStates.Edit) {
                    todoTitleValue =
                        (uiState.value as AddEditToDoScreenStates.Edit).todo.title
                    descriptionValue =
                        (uiState.value as AddEditToDoScreenStates.Edit).todo.description
                    dateValue = Calendar.getInstance().apply {
                        timeInMillis = (uiState.value as AddEditToDoScreenStates.Edit).todo.date
                    }.formatTimestamp()
                    checkValue = (uiState.value as AddEditToDoScreenStates.Edit).todo.haveAlarm
                }
            }
            TodoBodyMedium(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 22.dp),
                text = if (uiState.value is AddEditToDoScreenStates.Edit) "ویرایش تسک" else "افزودن تسک جدید",
                color = Black,
                textAlign = TextAlign.Center
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
                    .background(
                        color = White,
                        shape = Shapes().large.copy(
                            bottomEnd = CornerSize(0.dp),
                            bottomStart = CornerSize(0.dp)
                        )
                    )
            ) {
                Column {
                    TodoFiled(
                        title = "عنوان",
                        hint = "عنوان تسک را وارد نمایید",
                        value = todoTitleValue,
                        onValueChange = { newValue ->
                            todoTitleValue = newValue
                        },
                    )
                    TodoFiled(
                        title = "توضیحات",
                        hint = "توضیحات تسک را وارد نمایید",
                        value = descriptionValue,
                        onValueChange = { newValue ->
                            descriptionValue = newValue
                        },
                    )
                    TodoFiled(
                        enable = false,
                        title = "تاریخ",
                        hint = "تاریخ انجام را انتخاب کنید",
                        value = dateValue,
                        onclick = { showDateTimePicker = true },
                        onValueChange = { newValue ->
                            dateValue = newValue
                        },
                    )
                    ToDoOption(checkValue, { checkValue = !checkValue })
                }

                Box(
                    modifier = Modifier
                        .clickable {
                            if (todoTitleValue.isNotEmpty()
                                && descriptionValue.isNotEmpty()
                                && dateValue.isNotEmpty()
                            ) {
                                if (uiState.value is AddEditToDoScreenStates.Edit) {
                                    viewModel.onEvent(
                                        AddEditToDoScreenEvents.EditToDo(
                                            Todo(
                                                title = todoTitleValue,
                                                description = descriptionValue,
                                                date = todoReminder.timeInMillis,
                                                haveAlarm = checkValue,
                                                modifyDate = System.currentTimeMillis()
                                                    .toString()
                                            )
                                        )
                                    )
                                } else {
                                    viewModel.onEvent(
                                        AddEditToDoScreenEvents.AddToDo(
                                            Todo(
                                                title = todoTitleValue,
                                                description = descriptionValue,
                                                date = todoReminder.timeInMillis,
                                                haveAlarm = checkValue,
                                                modifyDate = System.currentTimeMillis()
                                                    .toString()
                                            )
                                        )
                                    )
                                }
                                navigateToHomeScreen.invoke()
                            } else {
                                Toast.makeText(
                                    context,
                                    "لطفا همه مشخصات را وارد کنید!",
                                    Toast.LENGTH_LONG,
                                ).show()
                            }
                        }
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(Iceberg, Turquoise)
                            ),
                            shape = CircleShape
                        )
                ) {
                    TodoBodyMedium(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        text = if (uiState.value is AddEditToDoScreenStates.Edit) "ویرایش" else "افزودن",
                        color = White,
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
        if (showDateTimePicker) {
            ReminderDateTimePicker(
                modifier = Modifier.align(Alignment.Center),
                onDateTimeSelected = { selectedDateTime ->
                    dateValue = selectedDateTime.formatTimestamp()
                    todoReminder = selectedDateTime
                    showDateTimePicker = false
                },
            )
        }
    }
}

@Composable
fun TodoFiled(
    onclick: (() -> Unit)? = null,
    enable: Boolean = true,
    title: String,
    value: String,
    hint: String,
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        TodoBodySmall(
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            text = title,
            color = Black
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onclick?.invoke()
                }
                .background(Cultured, shape = CircleShape)
                .border(width = 1.dp, color = BlackAlpha4f, shape = CircleShape)
                .padding(horizontal = 14.dp, vertical = 4.dp)
        ) {
            TodoTextFieldLabelMedium(
                enable = enable,
                modifier = Modifier.fillMaxWidth(),
                value = value,
                hint = hint,
                hintColor = BlackAlpha4f,
                color = Black,
                onValueChange = onValueChange
            )
        }
    }
}

@Composable
fun ToDoOption(isChecked: Boolean, onValueChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(checked = isChecked, onCheckedChange = onValueChange)
        TodoBodyMedium(text = "یاداور", color = Black)
    }
}