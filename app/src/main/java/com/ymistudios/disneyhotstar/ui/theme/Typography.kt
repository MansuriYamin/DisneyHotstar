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

    val titleMedium: TextStyle
        @Composable get() = circularStdTextStyle.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 16.ssp
        )

    val titleMediumSmall: TextStyle
        @Composable get() = titleMedium.copy(
            fontSize = 14.ssp
        )

    val titleBold: TextStyle
        @Composable get() = titleMedium.copy(
            fontWeight = FontWeight.Bold
        )

    val subTitle: TextStyle
        @Composable get() = circularStdTextStyle.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 12.ssp
        )

    val subTitleMedium: TextStyle
        @Composable get() = subTitle.copy(
            fontWeight = FontWeight.Medium
        )

    val body: TextStyle
        @Composable get() = circularStdTextStyle.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 10.ssp
        )

    val bodySmall: TextStyle
        @Composable get() = body.copy(
            fontSize = 8.ssp
        )

    val bodyMedium: TextStyle
        @Composable get() = bodySmall.copy(
            fontWeight = FontWeight.Medium
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

/*@Immutable
class Typography(
    val toolbarTitle: TextStyle = circularStdTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp
    ),

    val titleMedium: TextStyle = circularStdTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp
    ),

    val titleMediumSmall: TextStyle = titleMedium.copy(
        fontSize = 18.sp
    ),

    val titleBold: TextStyle = titleMedium.copy(
        fontWeight = FontWeight.Bold
    ),

    val subTitle: TextStyle = circularStdTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    val subTitleMedium: TextStyle = subTitle.copy(
        fontWeight = FontWeight.Medium
    ),

    val body: TextStyle = circularStdTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    val bodySmall: TextStyle = body.copy(
        fontSize = 12.sp
    ),

    val bodyMedium: TextStyle = circularStdTextStyle.copy(
        fontWeight = FontWeight.Medium
    ),

    val textFieldHint: TextStyle = circularStdTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    val textField: TextStyle = circularStdTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),

    val textFieldError: TextStyle = circularStdTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)*/

val LocalTypography = staticCompositionLocalOf {
    Typography()
}