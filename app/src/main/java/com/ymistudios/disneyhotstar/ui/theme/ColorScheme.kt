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
    iconForeground: Color,
    iconBackground: Color,
    text: Color,
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
    var iconForeground by mutableStateOf(iconForeground)
        private set
    var iconBackground by mutableStateOf(iconBackground)
        private set
    var text by mutableStateOf(text)
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
        iconForeground = other.iconForeground
        iconBackground = other.iconBackground
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
        iconForeground = iconForeground,
        iconBackground = iconBackground,
        text = text,
        subTitle = subTitle,
        secondaryBackground = secondaryBackground,
        hint = hint,
        divider = divider,
        dividerLight = dividerLight,
        isDark = isDark
    )
}

/* ------------- Light Color Schemes ------------- */
fun darkColorScheme() = Colors(
    primary = Black,
    onPrimary = Color.White,
    background = Black,
    toolbar = Black,
    border = Black,
    iconForeground = White.copy(alpha = 0.8f),
    iconBackground = DarkGray,
    text = White.copy(alpha = 0.8f),
    subTitle = White.copy(alpha = 0.5f),
    secondaryBackground = Color.White.copy(alpha = 0.5f),
    hint = White.copy(alpha = 0.5f),
    divider = White,
    dividerLight = White.copy(alpha = 0.05f),
    isDark = false
)

val LocalPicVerseColors = staticCompositionLocalOf {
    darkColorScheme()
}