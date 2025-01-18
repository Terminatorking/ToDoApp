package ghazimoradi.soheil.core.designSystem.components

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection

@SuppressLint("ModifierParameter")
@Composable
fun TodoDisplayLarge(
    singleLine: Int = Int.MAX_VALUE,
    shadow: Shadow = Shadow(),
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.displayLarge.copy(
            shadow = shadow,
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@SuppressLint("ModifierParameter")
@Composable
fun TodoLabelLarge(
    singleLine: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelLarge.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}
@SuppressLint("ModifierParameter")
@Composable
fun TodoLabelMedium(
    singleLine: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@SuppressLint("ModifierParameter")
@Composable
fun TodoBodyLarge(
    singleLine: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyLarge.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@SuppressLint("ModifierParameter")
@Composable
fun TodoBodyMedium(
    singleLine: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoBodySmall(
    singleLine: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.Normal,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodySmall.copy(
            fontWeight = fontWeight,
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}