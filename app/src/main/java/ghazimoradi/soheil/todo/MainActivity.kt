package ghazimoradi.soheil.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ghazimoradi.soheil.core.designSystem.theme.TodoTheme
import ghazimoradi.soheil.feature.addedittodo.AddEditToDoScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AddEditToDoScreen(innerPadding)
                }
            }
        }
    }
}
