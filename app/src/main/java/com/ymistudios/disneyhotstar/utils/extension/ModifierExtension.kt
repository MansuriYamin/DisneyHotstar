package com.ymistudios.disneyhotstar.utils.extension

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.ymistudios.disneyhotstar.ui.theme.AppTheme

fun Modifier.horizontalSpacing(): Modifier = composed {
    this.padding(horizontal = AppTheme.dimension.horizontalSpacing)
}

fun Modifier.verticalSpacing(): Modifier = composed {
    this.padding(vertical = AppTheme.dimension.verticalSpacing)
}