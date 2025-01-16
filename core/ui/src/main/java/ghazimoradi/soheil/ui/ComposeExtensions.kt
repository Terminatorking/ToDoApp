package ghazimoradi.soheil.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Int.ToHorizontalSpace() = HorizontalDivider(modifier = Modifier.width(this.dp))

@Composable
fun Int.ToVerticalSpace() = VerticalDivider(modifier = Modifier.height(this.dp))