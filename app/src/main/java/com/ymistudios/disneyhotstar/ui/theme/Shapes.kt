package com.ymistudios.disneyhotstar.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import javax.annotation.concurrent.Immutable

@Immutable
data class Shapes(
    val regular: RoundedCornerShape = RoundedCornerShape(8.dp),
    val button: RoundedCornerShape = RoundedCornerShape(20.dp),
    val card: RoundedCornerShape = RoundedCornerShape(10.dp),
    val circle: RoundedCornerShape = RoundedCornerShape(percent = 100),
    val textField: RoundedCornerShape = circle,
    val bottomRoundedCorners: RoundedCornerShape = RoundedCornerShape(
        bottomStart = 15.dp,
        bottomEnd = 15.dp
    )
)

val LocalShapes = staticCompositionLocalOf {
    Shapes()
}
