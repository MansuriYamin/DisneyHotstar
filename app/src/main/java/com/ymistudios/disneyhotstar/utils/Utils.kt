package com.ymistudios.disneyhotstar.utils

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun verticalEnterAnimation() = slideIn(initialOffset = {
    IntOffset(0, it.height / 2)
}) + fadeIn()

@Composable
fun verticalExitAnimation() = slideOut(targetOffset = {
    IntOffset(0, it.height / 2)
}) + fadeOut()

fun <T> getCamelCaseString(value: T): String {
    val regex = "([a-z])([A-Z])".toRegex()
    val replacement = "$1_$2"

    return value?.let {
        regex.replace(it::class.java.simpleName, replacement)
            .lowercase(Locale.getDefault())
    } ?: ""
}

@Composable
private fun Int.sdpGet(): Dp {
    val id = when (this) {
        in 1..600 -> "_${this}sdp"
        in (-60..-1) -> "_minus${this}sdp"
        else -> return this.dp
    }

    val resourceField = getFieldId(id)
    return if (resourceField != 0) dimensionResource(resourceField) else this.dp
}

@Composable
private fun getFieldId(id: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(id, "dimen", context.packageName)

}

val Int.sdp: Dp
    @Composable
    get() = this.sdpGet()

@Composable
private fun Int.ssp(density: Density): TextUnit = with(density) {
    this@ssp.sdp.toSp()
}

val Int.ssp: TextUnit
    @Composable get() = this.ssp(density = LocalDensity.current)
