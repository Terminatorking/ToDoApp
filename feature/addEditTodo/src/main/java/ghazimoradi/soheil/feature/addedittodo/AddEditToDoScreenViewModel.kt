package ghazimoradi.soheil.feature.addedittodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ghazimoradi.soheil.core.model.Todo
import ghazimoradi.soheil.domain.AddNewTodoUseCase
import ghazimoradi.soheil.feature.addedittodo.Events.AddEditToDoScreenEvents
import ghazimoradi.soheil.feature.addedittodo.states.AddEditToDoScreenStates
import ghazimoradi.soheil.feature.addedittodo.states.AddEditToDoScreenStates.Empty
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditToDoScreenViewModel @Inject constructor(
    private val addNewTodoUseCase: AddNewTodoUseCase
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<AddEditToDoScreenStates>(Empty())
    val uiState: StateFlow<AddEditToDoScreenStates> get() = _uiState

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