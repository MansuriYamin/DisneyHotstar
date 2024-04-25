package com.ymistudios.disneyhotstar.ui.components.button

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import com.ymistudios.disneyhotstar.ui.components.LoadingIndicator
import com.ymistudios.disneyhotstar.ui.theme.AppTheme
import com.ymistudios.disneyhotstar.utils.sdp

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    enabled: Boolean = !loading,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = AppTheme.colors.primary,
        contentColor = AppTheme.colors.onPrimary
    ),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    val contentAlpha by animateFloatAsState(
        targetValue = if (loading) 0f else 1f,
        animationSpec = tween(durationMillis = 0),
        label = "contentAlpha"
    )
    val loadingAlpha by animateFloatAsState(
        targetValue = if (loading) 1f else 0f,
        animationSpec = tween(durationMillis = 0),
        label = "loadingAlpha"
    )

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = {
            ProvideTextStyle(
                value = AppTheme.typography.body,
                content = {
            Box(contentAlignment = Alignment.Center) {
                LoadingIndicator(
                    animating = loading,
                    modifier = Modifier.graphicsLayer { alpha = loadingAlpha }
                )

                Row(
                    modifier = Modifier.graphicsLayer { alpha = contentAlpha },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    content()
                }
            }
}
)
        }
    )
}

private val ButtonHorizontalPadding
    @Composable get() = 18.sdp

private val ButtonVerticalPadding
    @Composable get() = 14.sdp

private val ContentPadding
    @Composable get() = PaddingValues(
        start = ButtonHorizontalPadding,
        top = ButtonVerticalPadding,
        end = ButtonHorizontalPadding,
        bottom = ButtonVerticalPadding
    )
