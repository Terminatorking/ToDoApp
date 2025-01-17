package ghazimoradi.soheil.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ghazimoradi.soheil.domain.usecases.DeleteTodoUseCase
import ghazimoradi.soheil.domain.usecases.GetDoneTodosUseCase
import ghazimoradi.soheil.domain.usecases.GetTodosUseCase
import ghazimoradi.soheil.domain.usecases.UpdateTodoUseCase
import ghazimoradi.soheil.feature.home.events.HomeScreenEvents
import ghazimoradi.soheil.feature.home.states.HomeScreenStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getDoneTodosUseCase: GetDoneTodosUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val getTodosUseCase: GetTodosUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeScreenStates>(HomeScreenStates.Loading)
    val uiState: StateFlow<HomeScreenStates> get() = _uiState

    init {
        updateTodoList()
    }

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.Update -> updateTodoList()
            is HomeScreenEvents.Delete -> {
                viewModelScope.launch {
                    deleteTodoUseCase.invoke(event.todo)
                    updateTodoList()
                }
            }

            is HomeScreenEvents.Done -> {
                viewModelScope.launch {
                    updateTodoUseCase.invoke(event.todo)
                    updateTodoList()
                }
            }
        }
    }

    private fun updateTodoList() {
        viewModelScope.launch {
            _uiState.update {
                HomeScreenStates.Success(
                    todoList = getTodosUseCase.invoke(),
                    doneTodoList = getDoneTodosUseCase.invoke()
                )
            }
        }
    }
}