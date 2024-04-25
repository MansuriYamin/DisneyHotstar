package com.ymistudios.disneyhotstar.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ymistudios.disneyhotstar.ui.theme.AppTheme

@Composable
fun Scaffold(
    topBar: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        containerColor = AppTheme.colors.background
    ) {
        Box(modifier = Modifier.padding(it)) {
            content(it)
        }
    }
}