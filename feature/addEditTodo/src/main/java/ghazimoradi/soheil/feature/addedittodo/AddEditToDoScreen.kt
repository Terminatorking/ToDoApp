package ghazimoradi.soheil.feature.addedittodo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ghazimoradi.soheil.core.designSystem.components.TodoBodyMedium
import ghazimoradi.soheil.core.designSystem.components.TodoBodySmall
import ghazimoradi.soheil.core.designSystem.components.TodoLabelLarge
import ghazimoradi.soheil.core.designSystem.theme.Black
import ghazimoradi.soheil.core.designSystem.theme.BlackAlpha4f
import ghazimoradi.soheil.core.designSystem.theme.Cultured
import ghazimoradi.soheil.core.designSystem.theme.White

@Composable
fun AddEditToDoScreen(paddingValues: PaddingValues) {
    var todoTitleValue = remember {
        mutableStateOf("")
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
                TodoFiled(
                    title = "عنوان",
                    hint = "عنوان تسک را وارد نمایید",
                    value = todoTitleValue.value,
                    onValueChange = { newValue ->
                        todoTitleValue.value = newValue
                    },
                )
            }
        }
    }
}

@Composable
fun TodoFiled(title: String, value: String, hint: String, onValueChange: (String) -> Unit) {
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
                .background(Cultured, shape = CircleShape)
                .border(width = 1.dp, color = BlackAlpha4f, shape = CircleShape)
                .padding(horizontal = 14.dp, vertical = 4.dp)
        ) {
            BasicTextField(
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    textDirection = TextDirection.Rtl

                ),
                value = value,
                modifier = Modifier.fillMaxWidth().height(25.dp),
                decorationBox = {
                    if (value.isEmpty()) {
                        TodoLabelLarge(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start,
                            text = hint,
                            color = BlackAlpha4f
                        )
                    }
                    it()
                },
                onValueChange = onValueChange
            )
        }
    }
}