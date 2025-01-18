package ghazimoradi.soheil.feature.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designSystem.components.TodoBodySmall
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.Add
import ghazimoradi.soheil.core.designSystem.theme.Black
import ghazimoradi.soheil.core.designSystem.theme.Iceberg
import ghazimoradi.soheil.core.designSystem.theme.Turquoise
import ghazimoradi.soheil.core.designSystem.theme.White
import ghazimoradi.soheil.feature.home.R


@Composable
fun EmptyView(navigateToAddTodoScreen: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(R.drawable.empty),
                    contentDescription = ""
                )
                TodoBodySmall(
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    text = "وظیفه ایی اضافه نشده",
                    color = Black
                )
            }
        }
        Box(
            modifier = Modifier
                .clickable { navigateToAddTodoScreen.invoke() }
                .padding(bottom = 56.dp, end = 32.dp)
                .size(56.dp)
                .background(
                    shape = CircleShape, brush = Brush.verticalGradient(
                        listOf(
                            Iceberg,
                            Turquoise,
                        )
                    )
                )
                .align(Alignment.BottomEnd),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                tint = White,
                modifier = Modifier.size(18.dp),
                imageVector = Add,
                contentDescription = "Add Task"
            )
        }
    }
}