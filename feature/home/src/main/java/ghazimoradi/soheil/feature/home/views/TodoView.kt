package ghazimoradi.soheil.feature.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designSystem.components.TodoBodyLarge
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.Add
import ghazimoradi.soheil.core.designSystem.theme.Black
import ghazimoradi.soheil.core.designSystem.theme.Iceberg
import ghazimoradi.soheil.core.designSystem.theme.Turquoise
import ghazimoradi.soheil.core.designSystem.theme.White
import ghazimoradi.soheil.core.model.Todo
import ghazimoradi.soheil.feature.home.HomeScreenViewModel
import ghazimoradi.soheil.feature.home.events.HomeScreenEvents
import ghazimoradi.soheil.feature.home.states.HomeScreenStates


@Composable
fun TodoView(
    viewModel: HomeScreenViewModel,
    paddingValues: PaddingValues,
    uiState: HomeScreenStates.Success,
    onOptionMenuClick: (Todo) -> Unit,
    navigateToAddTodoScreen: () -> Unit,
) {
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
            if (uiState.todoList.isNotEmpty()) {
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
                    val dismissBoxState = rememberSwipeToDismissBoxState(
                        confirmValueChange = {
                            when (it) {
                                SwipeToDismissBoxValue.StartToEnd -> {
                                    viewModel.onEvent(HomeScreenEvents.Done(todo = todo.copy(isDone = true)))
                                    true
                                }

                                SwipeToDismissBoxValue.EndToStart -> {
                                    viewModel.onEvent(HomeScreenEvents.Done(todo = todo.copy(isDone = true)))
                                    true
                                }

                                SwipeToDismissBoxValue.Settled -> {
                                    true
                                }
                            }
                        },
                        positionalThreshold = { it * 0.25f }
                    )
                    SwipeToDismissBox(
                        modifier = Modifier.padding(bottom = 12.dp),
                        content = {
                            ToDoItem(
                                isDone = todo.isDone,
                                todo = todo,
                                onOptionMenuClick = onOptionMenuClick,
                            )
                        },
                        state = dismissBoxState,
                        backgroundContent = {
                            BackgroundToDoItemSwipe()
                        },
                    )
                }

            }
            if (uiState.doneTodoList.isNotEmpty()) {
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
                    ToDoItem(
                        isDone = todo.isDone,
                        todo = todo,
                        onOptionMenuClick = onOptionMenuClick,
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .clickable { navigateToAddTodoScreen.invoke() }
                .padding(bottom = 56.dp, end = 32.dp)
                .size(56.dp)
                .background(
                    shape = CircleShape, brush = Brush.verticalGradient(
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