package ghazimoradi.soheil.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor() : ViewModel() {
    private val _navigateToHomeScreen = MutableStateFlow(false)
    val navigateToHomeScreen: StateFlow<Boolean> get() = _navigateToHomeScreen

    init {
        viewModelScope.launch {
            delay(2000).also {
                _navigateToHomeScreen.update { true }
            }
        }
    }
}