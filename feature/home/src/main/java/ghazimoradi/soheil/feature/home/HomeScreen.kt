package ghazimoradi.soheil.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ghazimoradi.soheil.core.designSystem.components.TodoBodyLarge
import ghazimoradi.soheil.core.designSystem.components.TodoBodyMedium
import ghazimoradi.soheil.core.designSystem.components.TodoBodySmall
import ghazimoradi.soheil.core.designSystem.components.TodoLabelMedium
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.Add
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.Clock
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.More
import ghazimoradi.soheil.core.designSystem.theme.Black
import ghazimoradi.soheil.core.designSystem.theme.BlackAlpha2f
import ghazimoradi.soheil.core.designSystem.theme.BlackAlpha4f
import ghazimoradi.soheil.core.designSystem.theme.BlackAlpha7f
import ghazimoradi.soheil.core.designSystem.theme.BlackAlphaHalf
import ghazimoradi.soheil.core.designSystem.theme.Iceberg
import ghazimoradi.soheil.core.designSystem.theme.Turquoise
import ghazimoradi.soheil.core.designSystem.theme.White
import ghazimoradi.soheil.core.designSystem.theme.WhiteAlphaHalf
import ghazimoradi.soheil.core.model.Todo
import ghazimoradi.soheil.feature.home.states.HomeScreenStates

@Composable
fun HomeScreen(paddingValues: PaddingValues, viewModel: HomeScreenViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState().value
    when (uiState) {
        HomeScreenStates.Loading -> {}
        is HomeScreenStates.Success -> {
            if (uiState.todoList.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 32.dp, horizontal = 24.dp)
                            .align(Alignment.TopCenter)
                    ) {
                        item {
                            TodoBodyLarge(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 18.dp),
                                text = "کارهای پیش رو",
                                color = Black,
                                textAlign = TextAlign.Start
                            )
                        }
                        items(uiState.todoList, key = { it.id }) { todo ->
                            ToDoItem(isDone = false, todo = todo)
                        }
                        item {
                            TodoBodyLarge(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 18.dp),
                                text = "کارهای انجام شده",
                                color = Black,
                                textAlign = TextAlign.Start
                            )
                        }
                        items(uiState.doneTodoList, key = { it.id }) { todo ->
                            ToDoItem(isDone = true, todo = todo)
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(bottom = 56.dp, end = 32.dp)
                            .size(56.dp)
                            .background(
                                shape = CircleShape,
                                brush = Brush.verticalGradient(
                                    listOf(
                                        Iceberg,
                                        Turquoise,
                                    )
                                )
                            )
                            .align(Alignment.BottomEnd),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            tint = White,
                            modifier = Modifier.size(18.dp),
                            imageVector = Add,
                            contentDescription = "Add Task"
                        )
                    }
                }
            } else {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Icon(
                                modifier = Modifier.fillMaxWidth(),
                                painter = painterResource(R.drawable.empty),
                                contentDescription = ""
                            )
                            TodoBodySmall(
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(),
                                text = "وظیفه ایی اضافه نشده",
                                color = Black
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(bottom = 56.dp, end = 32.dp)
                            .size(56.dp)
                            .background(
                                shape = CircleShape,
                                brush = Brush.verticalGradient(
                                    listOf(
                                        Iceberg,
                                        Turquoise,
                                    )
                                )
                            )
                            .align(Alignment.BottomEnd),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            tint = White,
                            modifier = Modifier.size(18.dp),
                            imageVector = Add,
                            contentDescription = "Add Task"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ToDoItem(todo: Todo, isDone: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = if (isDone) WhiteAlphaHalf else White, shape = Shapes().large)
                .padding(vertical = 4.dp, horizontal = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    tint = if (isDone) BlackAlpha4f else BlackAlpha7f,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(22.dp),
                    imageVector = More,
                    contentDescription = "More",
                )
                Column(horizontalAlignment = Alignment.Start) {
                    Icon(
                        tint = if (isDone) BlackAlpha2f else BlackAlphaHalf,
                        modifier = Modifier.size(18.dp),
                        imageVector = Clock,
                        contentDescription = "Alarm"
                    )
                    TodoLabelMedium(
                        text = todo.date,
                        color = if (isDone) BlackAlpha2f else BlackAlphaHalf
                    )
                }
            }
            Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                TodoBodyMedium(
                    modifier = Modifier.fillMaxWidth(),
                    text = todo.title,
                    color = if (isDone) BlackAlpha4f else BlackAlpha7f,
                    textAlign = TextAlign.Start
                )
                TodoBodySmall(
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.fillMaxWidth(),
                    text = todo.description,
                    color = if (isDone) BlackAlpha2f else BlackAlpha4f,
                    textAlign = TextAlign.Start
                )
            }
        }
        if (isDone) {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(0.9f),
                thickness = 1.5.dp,
                color = BlackAlpha2f
            )
        }
    }
}