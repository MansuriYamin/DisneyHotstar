package com.ymistudios.disneyhotstar.domain.navigator

import androidx.navigation.NavOptionsBuilder
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Route
import kotlinx.coroutines.flow.Flow

interface Navigator {

    val navigationActionFlow: Flow<NavigationAction>

    fun navigate(
        route: Route,
        onlyIfResumed: Boolean = true,
        builder: NavOptionsBuilder.() -> Unit = {}
    )

    fun navigateBack()

    fun navigateBack(
        route: Route,
        inclusive: Boolean = false,
        saveState: Boolean = false
    )

    fun <T> navigateBackWithResult(key: String, value: T?)
}