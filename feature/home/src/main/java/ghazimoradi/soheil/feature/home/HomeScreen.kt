package ghazimoradi.soheil.feature.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.Delete
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.Edit
import ghazimoradi.soheil.core.model.Todo
import ghazimoradi.soheil.feature.home.events.HomeScreenEvents
import ghazimoradi.soheil.feature.home.states.HomeScreenStates
import ghazimoradi.soheil.feature.home.views.EmptyView
import ghazimoradi.soheil.feature.home.views.TodoView
import ghazimoradi.soheil.ui.Option
import ghazimoradi.soheil.ui.OptionBottomSheet

object TodoOptions {
    const val Edit = "ویرایش"
    const val Delete = "حذف"
}

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navigateToAddTodoScreen: () -> Unit,
    navigateToEditTodoScreen: (Int) -> Unit
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleState = lifecycleOwner.lifecycle.currentState

    val options: List<Option> = remember {
        listOf(
            Option(name = TodoOptions.Edit, icon = Edit),
            Option(name = TodoOptions.Delete, icon = Delete),
        )
    }
    val uiState = viewModel.uiState.collectAsState().value
    var showOptionsBottomSheet by remember {
        mutableStateOf(false)
    }
    var selectedTodo = remember {
        mutableStateOf<Todo?>(null)
    }

    when (uiState) {
        is HomeScreenStates.Loading -> {}
        is HomeScreenStates.Success -> {
            if (uiState.todoList.isNotEmpty() || uiState.doneTodoList.isNotEmpty()) {

                LaunchedEffect(lifecycleState) {
                    if (lifecycleState == Lifecycle.State.STARTED || lifecycleState == Lifecycle.State.CREATED) {
                        viewModel.onEvent(HomeScreenEvents.Update)
                    }
                }

                if (showOptionsBottomSheet) {
                    OptionBottomSheet(
                        options = options,
                        onDismissRequest = {
                            selectedTodo.value = null
                            showOptionsBottomSheet = false
                        },
                        onOptionSelect = { option ->
                            val selectedOption = options.find { it.name == option.name }
                            if (selectedOption?.name == TodoOptions.Edit) {
                                selectedTodo.value?.let {
                                    navigateToEditTodoScreen.invoke(it.id)
                                }
                                showOptionsBottomSheet = false
                            } else {
                                selectedTodo.value?.let {
                                    viewModel.onEvent(HomeScreenEvents.Delete(it))
                                    showOptionsBottomSheet = false
                                }
                            }
                        },
                    )
                }
                TodoView(
                    paddingValues = paddingValues,
                    uiState = uiState,
                    onOptionMenuClick = {
                        selectedTodo.value = it
                        showOptionsBottomSheet = true
                    },
                    navigateToAddTodoScreen = navigateToAddTodoScreen,
                    viewModel = viewModel
                )
            } else {
                EmptyView(navigateToAddTodoScreen = navigateToAddTodoScreen)
            }
        }
    }
}
