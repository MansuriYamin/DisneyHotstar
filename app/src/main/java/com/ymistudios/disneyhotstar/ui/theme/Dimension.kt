package com.ymistudios.disneyhotstar.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ymistudios.disneyhotstar.utils.sdp

@Immutable
data class Dimension(
    val regular: Dp = 8.dp,

    val defaultMargin: Dp = 10.dp,

    val horizontalListSpacing: Dp = 12.dp,
    val verticalListSpacing: Dp = 12.dp,

    val paddingSmall: Dp = 10.dp,
    val paddingMedium: Dp = 20.dp,
    val paddingLarge: Dp = 25.dp,

    val buttonHorizontalPadding: Dp = 24.dp,
    val buttonVerticalPadding: Dp = 18.dp
) {
    val horizontalSpacing: Dp
        @Composable get() = 8.sdp

    val verticalSpacing: Dp
        @Composable get() = 10.sdp

    val iconSize: Dp
        @Composable get() = 40.sdp

    val sizeMedium: Dp
        @Composable get() = 50.sdp

    val moviePosterWidth: Dp
        @Composable get() = 100.sdp

    val small: Dp
        @Composable get() = 8.sdp

    val medium: Dp
        @Composable get() = 16.sdp

    val marginExtraLarge: Dp
        @Composable get() = 60.sdp
}

val LocalDimension = staticCompositionLocalOf {
    Dimension()
}