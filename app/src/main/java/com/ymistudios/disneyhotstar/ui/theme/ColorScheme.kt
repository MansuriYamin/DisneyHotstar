package com.ymistudios.disneyhotstar.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
class Colors(
    primary: Color,
    onPrimary: Color,
    background: Color,
    toolbar: Color,
    border: Color,
    icon: Color,
    title: Color,
    subTitle: Color,
    secondaryBackground: Color,
    hint: Color,
    divider: Color,
    dividerLight: Color,
    isDark: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var background by mutableStateOf(background)
        private set
    var toolbar by mutableStateOf(toolbar)
        private set
    var border by mutableStateOf(border)
        private set
    var icon by mutableStateOf(icon)
        private set
    var text by mutableStateOf(title)
        private set
    var subTitle by mutableStateOf(subTitle)
        private set
    var secondaryBackground by mutableStateOf(secondaryBackground)
        private set
    var hint by mutableStateOf(hint)
        private set
    var divider by mutableStateOf(divider)
        private set
    var dividerLight by mutableStateOf(dividerLight)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: Colors) {
        primary = other.primary
        onPrimary = other.onPrimary
        background = other.background
        toolbar = other.toolbar
        border = other.border
        icon = other.icon
        text = other.text
        subTitle = other.subTitle
        secondaryBackground = other.secondaryBackground
        hint = other.hint
        divider = other.divider
        dividerLight = other.dividerLight
        isDark = other.isDark
    }

    fun copy(): Colors = Colors(
        primary = primary,
        onPrimary = onPrimary,
        background = background,
        toolbar = toolbar,
        border = border,
        icon = icon,
        title = text,
        subTitle = subTitle,
        secondaryBackground = secondaryBackground,
        hint = hint,
        divider = divider,
        dividerLight = dividerLight,
        isDark = isDark
    )
}

/* ------------- Light Color Schemes ------------- */
fun lightColorScheme() = Colors(
    primary = Green,
    onPrimary = Color.White,
    background = Color.White,
    toolbar = Color.White,
    border = Color.White,
    icon = BlackLight.copy(alpha = 0.5f),
    title = BlackLight,
    subTitle = BlackLight.copy(alpha = 0.5f),
    secondaryBackground = Color.White.copy(alpha = 0.5f),
    hint = BlackLight.copy(alpha = 0.5f),
    divider = BlackLight,
    dividerLight = BlackLight.copy(alpha = 0.05f),
    isDark = false
)

val LocalPicVerseColors = staticCompositionLocalOf {
    lightColorScheme()
}