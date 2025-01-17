package ghazimoradi.soheil.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designSystem.components.TodoLabelLarge
import ghazimoradi.soheil.core.designSystem.theme.Black
import ghazimoradi.soheil.core.designSystem.theme.BlackAlpha2f
import ghazimoradi.soheil.core.designSystem.theme.BlackAlpha4f
import ghazimoradi.soheil.core.designSystem.theme.Cultured
import ghazimoradi.soheil.core.designSystem.theme.White

data class Option(val name: String, val icon: ImageVector)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionBottomSheet(
    options: List<Option>,
    onOptionSelect: (Option) -> Unit,
    onDismissRequest: () -> Unit
) {
    ModalBottomSheet(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Cultured),
        sheetState = rememberModalBottomSheetState(),
        onDismissRequest = onDismissRequest
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(options) { option ->
                OptionItem(option = option, onOptionClick = { onOptionSelect.invoke(option) })
            }
        }
    }
}

@Composable
private fun OptionItem(option: Option, onOptionClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onOptionClick.invoke() }
            .fillMaxWidth()
            .padding(12.dp)
            .background(White, shape = CircleShape)
            .border(width = 2.dp, color = BlackAlpha2f, shape = CircleShape)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = option.icon,
            contentDescription = "",
            tint = BlackAlpha4f
        )
        TodoLabelLarge(text = option.name, color = Black)
    }
}