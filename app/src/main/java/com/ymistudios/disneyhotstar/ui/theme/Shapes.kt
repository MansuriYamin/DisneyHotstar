package com.ymistudios.disneyhotstar.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import com.ymistudios.disneyhotstar.utils.sdp
import javax.annotation.concurrent.Immutable

@Immutable
class Shapes {
    val roundedCornersSmall: RoundedCornerShape
        @Composable get() = RoundedCornerShape(4.sdp)

    val roundedCorners: RoundedCornerShape
        @Composable get() = RoundedCornerShape(8.sdp)

    val roundedCornersExtraLarge: RoundedCornerShape
        @Composable get() = RoundedCornerShape(32.sdp)

    val card: RoundedCornerShape
        @Composable get() = RoundedCornerShape(10.sdp)

    val circle: RoundedCornerShape
        @Composable get() = CircleShape

    val textField: RoundedCornerShape
        @Composable get() = circle

    val bottomRoundedCorners: RoundedCornerShape
        @Composable get() = RoundedCornerShape(
            bottomStart = 32.sdp,
            bottomEnd = 32.sdp
        )
}

val LocalShapes = staticCompositionLocalOf {
    Shapes()
}
