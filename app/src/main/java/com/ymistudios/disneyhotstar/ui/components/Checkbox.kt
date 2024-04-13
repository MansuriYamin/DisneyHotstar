package com.ymistudios.disneyhotstar.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymistudios.disneyhotstar.ui.theme.AppTheme

@Composable
fun Checkbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
    text: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    iconChecked: @Composable () -> Unit = { CheckedIcon() },
    iconUnChecked: @Composable () -> Unit = { UnCheckedIcon() },
    enabled: Boolean = true
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Row(
        modifier = modifier
            .toggleable(
                value = checked,
                enabled = enabled,
                onValueChange = onCheckedChange,
                interactionSource = interactionSource,
                role = Role.Checkbox,
                indication = null
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedIconAlpha by animateFloatAsState(
            targetValue = if (checked) 1f else 0f,
            animationSpec = tween(durationMillis = 500)
        )

        val unCheckedIconAlpha by animateFloatAsState(
            targetValue = if (checked) 0f else 1f,
            animationSpec = tween(durationMillis = 500)
        )

        Box(
            modifier = Modifier
                .align(Alignment.Top)
                .clip(CircleShape)
                .indication(
                    interactionSource = interactionSource,
                    indication = rememberRipple()
                )
        ) {
            Box(modifier = Modifier.graphicsLayer { alpha = checkedIconAlpha }) {
                iconChecked()
            }
            Box(modifier = Modifier.graphicsLayer { alpha = unCheckedIconAlpha }) {
                iconUnChecked()
            }
        }

        Spacer(modifier = Modifier.width(5.dp))

        ProvideTextStyle(value = AppTheme.typography.subTitleMedium) {
            text()
        }
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
private fun CheckedIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .size(IconSize)
            .clip(CircleShape)
            .background(AppTheme.colors.primary)
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "CheckBox",
            tint = AppTheme.colors.onPrimary,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
private fun UnCheckedIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .size(IconSize)
            .clip(CircleShape)
            .border(
                width = 1.8.dp,
                color = AppTheme.colors.border,
                shape = CircleShape
            )
    )
}

@Preview(showBackground = true)
@Composable
fun CheckboxPrev() {
    var checked by remember {
        mutableStateOf(false)
    }
    Checkbox(checked = checked, onCheckedChange = {
        checked = !checked
    }, text = { Text(text = "Checkbox") })
}

private val IconSize = 24.dp
