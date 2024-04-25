package com.ymistudios.disneyhotstar.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.ymistudios.disneyhotstar.R
import com.ymistudios.disneyhotstar.utils.ssp

private val circularStd = FontFamily(
    Font(R.font.circular_std_regular, FontWeight.Normal),
    Font(R.font.circular_std_medium, FontWeight.Medium),
    Font(R.font.circular_std_bold, FontWeight.Bold),
    Font(R.font.circular_std_black, FontWeight.Black)
)

private val circularStdTextStyle =
    TextStyle(
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        fontFamily = circularStd
    )

@Immutable
class Typography {
    val toolbarTitle: TextStyle
        @Composable get() = circularStdTextStyle.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 16.ssp
        )

    val title: TextStyle
        @Composable get() = circularStdTextStyle.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 22.ssp
        )

    val subTitle: TextStyle
        @Composable get() = circularStdTextStyle.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 12.ssp
        )

    val body: TextStyle
        @Composable get() = circularStdTextStyle.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 14.ssp
        )

    val textFieldHint: TextStyle
        @Composable get() = circularStdTextStyle.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 10.ssp
        )

    val textField: TextStyle
        @Composable get() = circularStdTextStyle.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 10.ssp
        )

    val textFieldError: TextStyle
        @Composable get() = circularStdTextStyle.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 8.ssp
        )
}

val LocalTypography = staticCompositionLocalOf {
    Typography()
}