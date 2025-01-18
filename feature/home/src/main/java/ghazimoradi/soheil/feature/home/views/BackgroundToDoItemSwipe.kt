package ghazimoradi.soheil.feature.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.Done
import ghazimoradi.soheil.core.designSystem.theme.Black
import ghazimoradi.soheil.core.designSystem.theme.Green

@Composable
fun BackgroundToDoItemSwipe() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Green, shape = Shapes().large)
            .padding(14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(tint = Black,
            modifier = Modifier.size(24.dp),
            imageVector = Done,
            contentDescription = ""
        )
        Icon(tint = Black,
        modifier = Modifier.size(24.dp),
        imageVector = Done,
        contentDescription = ""
        )
    }
}