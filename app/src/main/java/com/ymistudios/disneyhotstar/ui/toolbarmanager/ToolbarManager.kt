package com.ymistudios.disneyhotstar.ui.toolbarmanager

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class MenuItem(
    val title: String = "",
    val icon: Painter,
    val onClick: () -> Unit
)

data class Toolbar(
    val toolbarTitle: String = "",
    val toolbarNavigationIcon: ImageVector = Icons.Default.Home,
    val toolbarBackgroundColor: Color = Color.Transparent,
    val menuItems: List<MenuItem> = emptyList(),
    val showBackButton: Boolean = false,
    val showToolbar: Boolean = false
)

object ToolbarManager {

    private val _toolbarState = MutableStateFlow(Toolbar())
    val toolbarState = _toolbarState.asStateFlow()

    fun setUpToolbar(toolbar: Toolbar) {
        _toolbarState.update { toolbar }
    }
}