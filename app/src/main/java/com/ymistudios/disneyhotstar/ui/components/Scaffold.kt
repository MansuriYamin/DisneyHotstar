package com.ymistudios.disneyhotstar.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.ymistudios.disneyhotstar.ui.theme.AppTheme

@OptIn(ExperimentalComposeUiApi::class)
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
        Box(modifier = Modifier
            .padding(it)
            .semantics { testTagsAsResourceId = true }
        ) {
            content(it)
        }
    }
}