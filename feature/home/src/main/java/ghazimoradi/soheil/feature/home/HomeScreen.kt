package ghazimoradi.soheil.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designSystem.components.*
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.Add
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.Clock
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.More
import ghazimoradi.soheil.core.designSystem.theme.*

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        TodoBodyLarge(
            modifier = Modifier.fillMaxWidth(),
            text = "کارهای پیش رو",
            color = Black,
            textAlign = TextAlign.Start
        )
        LazyColumn(
            modifier = Modifier.padding(12.dp)
                .fillMaxSize().padding(vertical = 32.dp, horizontal = 24.dp)
                .align(Alignment.TopCenter)
        ) {
            items(count = 4) {
                ToDoItem()
            }
        }
        Box(
            modifier = Modifier
                .padding(bottom = 56.dp, end = 32.dp)
                .size(56.dp)
                .background(
                    shape = CircleShape,
                    brush = Brush.verticalGradient(
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
                modifier = Modifier.size(26.dp),
                imageVector = Add,
                contentDescription = "Add Task"
            )
        }
    }
}

@Composable
fun ToDoItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth().padding(bottom = 12.dp)
            .background(White, shape = Shapes().large)
            .padding(vertical = 4.dp, horizontal = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                tint = BlackAlpha7f,
                modifier = Modifier.size(26.dp),
                imageVector = More,
                contentDescription = "More",
            )
            VerticalDivider(
                modifier = Modifier.height(32.dp),
                thickness = 2.dp,
                color = BlackAlpha2f
            )
            Column(horizontalAlignment = Alignment.Start) {
                Icon(
                    modifier = Modifier.size(26.dp),
                    imageVector = Clock,
                    contentDescription = "Alarm"
                )
                TodoLabelLarge(text = "2024/12/2 | 13:45", color = BlackAlphaHalf)
            }
        }
        Column(modifier = Modifier.fillMaxWidth(0.5f)) {
            TodoBodyMedium(
                modifier = Modifier.fillMaxWidth(),
                text = "title",
                color = Black,
                textAlign = TextAlign.Start
            )
            TodoBodySmall(
                modifier = Modifier.fillMaxWidth(),
                text = "Description",
                color = BlackAlphaHalf,
                textAlign = TextAlign.Start
            )
        }
    }
}