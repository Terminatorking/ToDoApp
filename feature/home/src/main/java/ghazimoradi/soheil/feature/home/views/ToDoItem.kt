package ghazimoradi.soheil.feature.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designSystem.components.TodoBodyMedium
import ghazimoradi.soheil.core.designSystem.components.TodoBodySmall
import ghazimoradi.soheil.core.designSystem.components.TodoLabelMedium
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.Clock
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.ClockOff
import ghazimoradi.soheil.core.designSystem.icons.TodoIcons.More
import ghazimoradi.soheil.core.designSystem.theme.BlackAlpha2f
import ghazimoradi.soheil.core.designSystem.theme.BlackAlpha4f
import ghazimoradi.soheil.core.designSystem.theme.BlackAlpha7f
import ghazimoradi.soheil.core.designSystem.theme.BlackAlphaHalf
import ghazimoradi.soheil.core.designSystem.theme.White
import ghazimoradi.soheil.core.designSystem.theme.WhiteAlphaHalf
import ghazimoradi.soheil.core.model.Todo
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun ToDoItem(todo: Todo, isDone: Boolean, onOptionMenuClick: (Todo) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = if (isDone) WhiteAlphaHalf else White, shape = Shapes().large)
                .padding(vertical = 4.dp, horizontal = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    tint = if (isDone) BlackAlpha4f else BlackAlpha7f,
                    modifier = Modifier
                        .clickable { onOptionMenuClick.invoke(todo) }
                        .padding(end = 10.dp)
                        .size(22.dp),
                    imageVector = More,
                    contentDescription = "More",
                )
                Column(horizontalAlignment = Alignment.Start) {
                    if (todo.haveAlarm) {
                        Icon(
                            tint = if (isDone) BlackAlpha2f else BlackAlphaHalf,
                            modifier = Modifier.size(18.dp),
                            imageVector = Clock,
                            contentDescription = "Alarm"
                        )
                    } else {
                        Icon(
                            tint = if (isDone) BlackAlpha2f else BlackAlphaHalf,
                            modifier = Modifier.size(18.dp),
                            imageVector = ClockOff,
                            contentDescription = "Alarm"
                        )
                    }

                    TodoLabelMedium(
                        text = SimpleDateFormat(
                            "HH:mm | yyyy/MM/dd",
                            Locale.getDefault()
                        ).format(Date(todo.date)),
                        color = if (isDone) BlackAlpha2f else BlackAlphaHalf
                    )
                }
            }
            Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                TodoBodyMedium(
                    singleLine = 1,
                    modifier = Modifier.fillMaxWidth(),
                    text = todo.title,
                    color = if (isDone) BlackAlpha4f else BlackAlpha7f,
                    textAlign = TextAlign.Start
                )
                TodoBodySmall(
                    singleLine = 1,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.fillMaxWidth(),
                    text = todo.description,
                    color = if (isDone) BlackAlpha2f else BlackAlpha4f,
                    textAlign = TextAlign.Start
                )
            }
        }
        if (isDone) {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(0.9f), thickness = 1.5.dp, color = BlackAlpha2f
            )
        }
    }
}