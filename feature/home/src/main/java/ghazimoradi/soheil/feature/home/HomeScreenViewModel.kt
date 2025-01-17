package ghazimoradi.soheil.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ghazimoradi.soheil.feature.home.states.HomeScreenStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<HomeScreenStates>(HomeScreenStates.Loading)
    val uiState: StateFlow<HomeScreenStates> get() = _uiState
}