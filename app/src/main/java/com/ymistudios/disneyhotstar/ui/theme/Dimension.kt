package com.ymistudios.disneyhotstar.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import com.ymistudios.disneyhotstar.utils.sdp

@Immutable
class Dimension {
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

    val trailerWidth: Dp
        @Composable get() = 200.sdp

    val extraSmall: Dp
        @Composable get() = 2.sdp

    val small: Dp
        @Composable get() = 4.sdp

    val default: Dp
        @Composable get() = 8.sdp

    val medium: Dp
        @Composable get() = 16.sdp

    val large: Dp
        @Composable get() = 24.sdp

    val extraLarge: Dp
        @Composable get() = 32.sdp

    val marginExtraLarge: Dp
        @Composable get() = 60.sdp
}

val LocalDimension = staticCompositionLocalOf {
    Dimension()
}