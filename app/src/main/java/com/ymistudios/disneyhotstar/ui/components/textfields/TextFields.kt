@file:OptIn(ExperimentalMaterial3Api::class)

package com.ymistudios.disneyhotstar.ui.components.textfields

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import com.ymistudios.disneyhotstar.domain.form.FormState
import com.ymistudios.disneyhotstar.ui.theme.AppTheme
import com.ymistudios.disneyhotstar.utils.sdp

private val textFieldColors
    @Composable get() = OutlinedTextFieldDefaults.colors(
        unfocusedBorderColor = AppTheme.colors.border,
        focusedBorderColor = AppTheme.colors.primary,
        unfocusedContainerColor = AppTheme.colors.secondaryBackground,
        focusedContainerColor = AppTheme.colors.secondaryBackground,
        errorContainerColor = AppTheme.colors.secondaryBackground
    )

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    error: String? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = AppTheme.typography.textField.copy(color = AppTheme.colors.text),
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    minLines: Int = 1,
    maxLines: Int = 1,
    maxLength: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = AppTheme.shapes.textField,
    colors: TextFieldColors = textFieldColors
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            if (it.length <= maxLength) {
                onValueChange(it)
            }
        },
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        placeholder = {
            Text(
                text = placeholder,
                style = AppTheme.typography.textFieldHint,
                color = AppTheme.colors.hint
            )
        },
        leadingIcon = leadingIcon?.let {
            @Composable {
                Decoration {
                    Row {
                        Spacer(modifier = Modifier.width(12.sdp))
                        leadingIcon()
                    }
                }
            }
        },
        trailingIcon = trailingIcon?.let {
            @Composable {
                Decoration {
                    Row {
                        trailingIcon()
                        Spacer(modifier = Modifier.width(12.sdp))
                    }
                }
            }
        },
        isError = error != null,
        supportingText = error?.let {
            {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    style = AppTheme.typography.textFieldError
                )
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        minLines = minLines,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )
}

@Composable
fun FormTextField(
    state: FormState,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = AppTheme.typography.textField.copy(color = AppTheme.colors.text),
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    maxLength: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = AppTheme.shapes.textField,
    colors: TextFieldColors = textFieldColors
) {
    TextField(
        modifier = modifier,
        value = state.value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        error = state.error?.asString(),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        maxLength = maxLength,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )
}

@Composable
fun Decoration(
    content: @Composable () -> Unit
) {
    val contentWithColor: @Composable () -> Unit = @Composable {
        CompositionLocalProvider(
            LocalContentColor provides Color.Unspecified,
            content = content
        )
    }
    contentWithColor()
}
