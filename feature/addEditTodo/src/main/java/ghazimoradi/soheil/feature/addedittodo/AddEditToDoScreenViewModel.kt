package ghazimoradi.soheil.feature.addedittodo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ghazimoradi.soheil.core.model.Todo
import ghazimoradi.soheil.domain.usecases.AddNewTodoUseCase
import ghazimoradi.soheil.domain.usecases.GetTodoByIdUseCase
import ghazimoradi.soheil.domain.usecases.UpdateTodoUseCase
import ghazimoradi.soheil.feature.addedittodo.Events.AddEditToDoScreenEvents
import ghazimoradi.soheil.feature.addedittodo.navigation.todoIdArg
import ghazimoradi.soheil.feature.addedittodo.states.AddEditToDoScreenStates
import ghazimoradi.soheil.feature.addedittodo.states.AddEditToDoScreenStates.Empty
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditToDoScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val addNewTodoUseCase: AddNewTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val getTodoByIdUseCase: GetTodoByIdUseCase
) : ViewModel() {

    val todoId: Int = savedStateHandle[todoIdArg] ?: -1

    private val _uiState =
        MutableStateFlow<AddEditToDoScreenStates>(Empty())
    val uiState: StateFlow<AddEditToDoScreenStates> get() = _uiState

    init {
        viewModelScope.launch {
            _uiState.update {
                AddEditToDoScreenStates.Edit(
                    getTodoByIdUseCase.invoke(todoId)
                )
            }
        }
    }

    fun onEvent(event: AddEditToDoScreenEvents) {
        when (event) {
            is AddEditToDoScreenEvents.AddToDo -> {
                addNewTodo(event.todo)
            }

            is AddEditToDoScreenEvents.EditToDo -> {}
        }
    }

    fun addNewTodo(todo: Todo) {
        viewModelScope.launch {
            addNewTodoUseCase.invoke(todo)
        }
        _uiState.update {
            Empty()
        }
    }
}