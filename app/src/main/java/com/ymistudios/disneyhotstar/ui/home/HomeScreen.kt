package com.ymistudios.disneyhotstar.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ymistudios.disneyhotstar.di.module.injectNavigator
import com.ymistudios.disneyhotstar.domain.navigator.Navigator
import com.ymistudios.disneyhotstar.ui.theme.AppTheme
import com.ymistudios.disneyhotstar.ui.toolbarmanager.Toolbar
import com.ymistudios.disneyhotstar.ui.toolbarmanager.ToolbarManager

@Composable
fun HomeScreen(navigator: Navigator = injectNavigator()) {
    ToolbarManager.setUpToolbar(Toolbar(showToolbar = false))

    HomeScreenContent()
}

@Composable
private fun HomeScreenContent() {
    Box(
        modifier = Modifier.fillMaxSize().background(AppTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Home")
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenContentPrev() {
    HomeScreenContent()
}
