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
fun TodoDisplayMedium(
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
        style = MaterialTheme.typography.displayMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}
@SuppressLint("ModifierParameter")
@Composable
fun TodoDisplaySmall(
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
        style = MaterialTheme.typography.displaySmall.copy(
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
fun TodoLabelSmall(
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
        style = MaterialTheme.typography.labelSmall.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}
@SuppressLint("ModifierParameter")
@Composable
fun TodoHeadlineLarge(
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
        style = MaterialTheme.typography.headlineLarge.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}
@SuppressLint("ModifierParameter")
@Composable
fun TodoHeadlineMedium(
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
        style = MaterialTheme.typography.headlineMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}
@SuppressLint("ModifierParameter")
@Composable
fun TodoHeadlineSmall(
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
        style = MaterialTheme.typography.headlineSmall.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}
@SuppressLint("ModifierParameter")
@Composable
fun TodoTitleLarge(
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
        style = MaterialTheme.typography.titleLarge.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}
@SuppressLint("ModifierParameter")
@Composable
fun TodoTitleMedium(
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
        style = MaterialTheme.typography.titleMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}
@SuppressLint("ModifierParameter")
@Composable
fun TodoTitleSmall(
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
        style = MaterialTheme.typography.titleSmall.copy(
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
@SuppressLint("ModifierParameter")
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