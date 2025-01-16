package ghazimoradi.soheil.core.designSystem.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection

@Composable
fun TodoDisplayLarge(
    shadow: Shadow = Shadow(),
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
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

@Composable
fun TodoDisplayMedium(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.displayMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoDisplaySmall(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.displaySmall.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoLabelLarge(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelLarge.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoLabelMedium(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoLabelSmall(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelSmall.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoHeadlineLarge(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineLarge.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoHeadlineMedium(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoHeadlineSmall(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineSmall.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoTitleLarge(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleLarge.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoTitleMedium(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoTitleSmall(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleSmall.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoBodyLarge(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyLarge.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@Composable
fun TodoBodyMedium(
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
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
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodySmall.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}