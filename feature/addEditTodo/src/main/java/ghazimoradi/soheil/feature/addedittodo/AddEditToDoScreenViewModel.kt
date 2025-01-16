package ghazimoradi.soheil.feature.addedittodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ghazimoradi.soheil.core.model.Todo
import ghazimoradi.soheil.domain.AddNewTodoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditToDoScreenViewModel @Inject constructor(
    private val addNewTodoUseCase: AddNewTodoUseCase
) : ViewModel() {
    fun addNewTodo(todo: Todo) {
        viewModelScope.launch {
            addNewTodoUseCase.invoke(todo)
        }
    }
}