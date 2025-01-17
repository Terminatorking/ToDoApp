package ghazimoradi.soheil.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ghazimoradi.soheil.domain.GetDoneTodosUseCase
import ghazimoradi.soheil.domain.GetTodosUseCase
import ghazimoradi.soheil.feature.home.states.HomeScreenStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getDoneTodosUseCase: GetDoneTodosUseCase,
    private val getTodosUseCase: GetTodosUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeScreenStates>(HomeScreenStates.Loading)
    val uiState: StateFlow<HomeScreenStates> get() = _uiState

    init {
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