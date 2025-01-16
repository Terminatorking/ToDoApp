package ghazimoradi.soheil.core.designSystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import ghazimoradi.soheil.core.designSystem.theme.Black

@Composable
fun TodoTextFieldDisplayLarge(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.displayLarge.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoDisplayLarge(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldDisplayMedium(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.displayMedium.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoDisplayMedium(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldDisplaySmall(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.displaySmall.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoDisplaySmall(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldLabelLarge(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.labelLarge.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoLabelLarge(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldLabelMedium(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.labelMedium.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoLabelMedium(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }
            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldLabelSmall(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.labelSmall.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoLabelSmall(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldHeadlineLarge(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.headlineLarge.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoHeadlineLarge(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldHeadlineMedium(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.headlineMedium.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoHeadlineMedium(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldHeadlineSmall(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.headlineSmall.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoHeadlineSmall(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldTitleLarge(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.titleLarge.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoTitleLarge(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldTitleMedium(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.titleMedium.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoTitleMedium(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldTitleSmall(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.titleSmall.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoTitleSmall(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldBodyLarge(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.displayLarge.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoBodyLarge(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldBodyMedium(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoBodyMedium(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}

@Composable
fun TodoTextFieldBodySmall(
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.bodySmall.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                TodoBodySmall(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }

            it()
        },
        onValueChange = onValueChange,
    )
}
