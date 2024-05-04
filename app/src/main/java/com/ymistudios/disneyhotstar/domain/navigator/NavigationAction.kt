package com.ymistudios.disneyhotstar.domain.navigator

import androidx.navigation.NavOptionsBuilder
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Destination

sealed class NavigationAction {
    data class NavigateTo(
        val destination: Destination,
        val onlyIfResumed: Boolean = true,
        val builder: NavOptionsBuilder.() -> Unit = {}
    ) : NavigationAction()

    data class NavigateBack(
        val destination: Destination? = null,
        val inclusive: Boolean = false,
        val saveState: Boolean = false
    ) : NavigationAction()

    data class NavigateBackWithResult<T>(val key: String, val value: T?) : NavigationAction()
}
