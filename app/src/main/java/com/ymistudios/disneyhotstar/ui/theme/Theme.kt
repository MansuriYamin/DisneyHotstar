package com.ymistudios.disneyhotstar.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colors = darkColorScheme()
    ProvideAppTheme(colors = colors, content = content)

    val systemUiController = rememberSystemUiController()
    val color = AppTheme.colors.background
    SideEffect {
        systemUiController.setSystemBarsColor(color = color)
    }
}

@Composable
fun ProvideAppTheme(
    colors: Colors = AppTheme.colors,
    typography: Typography = AppTheme.typography,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors.copy()
    }

    colorPalette.update(colors)

    val rippleIndication = rememberRipple()

    CompositionLocalProvider(
        LocalColors provides colorPalette,
        LocalIndication provides rippleIndication,
        LocalTypography provides AppTheme.typography
    ) {
        Box(modifier = Modifier.background(AppTheme.colors.background)) {
            ProvideTextStyle(
                value = typography.body,
                content = content
            )
        }
    }
}

object AppTheme {
    val colors: Colors
        @Composable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        get() = LocalTypography.current

    val dimension: Dimension
        @Composable
        get() = LocalDimension.current

    val shapes: Shapes
        @Composable
        get() = LocalShapes.current
}
