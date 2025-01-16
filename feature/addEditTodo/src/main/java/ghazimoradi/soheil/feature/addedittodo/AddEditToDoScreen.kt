package ghazimoradi.soheil.feature.addedittodo

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

@Composable
fun AddEditToDoScreen(
    paddingValues: PaddingValues,
    viewModel: AddEditToDoScreenViewModel = hiltViewModel()
) {
    var todoTitleValue = remember {
        mutableStateOf("")
    }
    var descriptorValue = remember {
        mutableStateOf("")
    }
    var dateValue = remember {
        mutableStateOf("")
    }
    var checkValue by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(horizontal = 15.dp)
            .background(color = Cultured)
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            TodoBodyMedium(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 22.dp),
                text = "افزودن تسک جدید",
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
                        value = todoTitleValue.value,
                        onValueChange = { newValue ->
                            todoTitleValue.value = newValue
                        },
                    )
                    TodoFiled(
                        title = "توضیحات",
                        hint = "توضیحات تسک را وارد نمایید",
                        value = descriptorValue.value,
                        onValueChange = { newValue ->
                            descriptorValue.value = newValue
                        },
                    )
                    TodoFiled(
                        title = "تاریخ",
                        hint = "تاریخ انجام را انتخاب کنید",
                        value = dateValue.value,
                        onValueChange = { newValue ->
                            dateValue.value = newValue
                        },
                    )
                    ToDoOption(checkValue, { checkValue = !checkValue })
                }

                Box(
                    modifier = Modifier
                        .clickable {
                            viewModel.onEvent(
                                AddEditToDoScreenEvents.AddToDo(
                                    Todo(
                                        title = todoTitleValue.value,
                                        description = descriptorValue.value,
                                        date = dateValue.value,
                                        haveAlarm = checkValue,
                                        modifyDate = System.currentTimeMillis().toString()
                                    )
                                )
                            )
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
                        text = "افزودن",
                        color = White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun TodoFiled(
    title: String,
    value: String, hint: String,
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
                .clickable {}
                .background(Cultured, shape = CircleShape)
                .border(width = 1.dp, color = BlackAlpha4f, shape = CircleShape)
                .padding(horizontal = 14.dp, vertical = 4.dp)
        ) {
            TodoTextFieldLabelMedium(
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