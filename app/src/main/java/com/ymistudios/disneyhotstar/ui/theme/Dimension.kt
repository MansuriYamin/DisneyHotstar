package com.ymistudios.disneyhotstar.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ymistudios.disneyhotstar.utils.sdp
import androidx.compose.runtime.Composable

@Immutable
data class Dimension(
    val regular: Dp = 8.dp,

    /*val horizontalSpacing: Dp = 22.dp,
    val verticalSpacing: Dp = 25.dp,*/

    val sizeMedium: Dp = 30.dp,
    val sizeLarge: Dp = 50.dp,

    val defaultMargin: Dp = 10.dp,
    val marginSmall: Dp = 15.dp,
    val marginMedium: Dp = 25.dp,
    val marginLarge: Dp = 35.dp,

    val horizontalListSpacing: Dp = 12.dp,
    val verticalListSpacing: Dp = 12.dp,

    val paddingSmall: Dp = 10.dp,
    val paddingMedium: Dp = 20.dp,
    val paddingLarge: Dp = 25.dp,

    val buttonHorizontalPadding: Dp = 24.dp,
    val buttonVerticalPadding: Dp = 18.dp,

    val iconButtonSize: Dp = 40.dp
) {
    val horizontalSpacing: Dp
        @Composable get() = 18.sdp

    val verticalSpacing: Dp
        @Composable get() = 20.sdp
}

val LocalDimension = staticCompositionLocalOf {
    Dimension()
}