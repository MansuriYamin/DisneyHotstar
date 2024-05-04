package com.ymistudios.disneyhotstar.domain.navigator

import androidx.navigation.NavOptionsBuilder
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Destination
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Route

sealed class NavigationAction {
    data class NavigateBack(
        val route: Route? = null,
        val inclusive: Boolean = false,
        val saveState: Boolean = false
    ) : NavigationAction()

    data class NavigateBackWithResult<T>(val key: String, val value: T?) : NavigationAction()

    data class NavigateTo(
        val destination: Destination,
        val onlyIfResumed: Boolean = true,
        val builder: NavOptionsBuilder.() -> Unit = {}
    ) : NavigationAction()
}
