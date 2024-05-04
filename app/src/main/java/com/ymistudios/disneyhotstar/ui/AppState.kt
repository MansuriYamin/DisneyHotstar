package com.ymistudios.disneyhotstar.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.rememberNavController
import com.ymistudios.disneyhotstar.ui.navigation.destinations.DashboardDestinations
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Destination
import com.ymistudios.disneyhotstar.ui.toolbarmanager.ToolbarManager

@Stable
class AppState(
    val navController: NavHostController,
    val toolbarManager: ToolbarManager
) {

    fun navigate(
        destination: Destination,
        onlyIfResumed: Boolean = true,
        builder: NavOptionsBuilder.() -> Unit = {}
    ) {
        if (onlyIfResumed && navController.currentBackStackEntry?.lifecycleIsResumed() == false)
            return

        navController.navigate(destination, builder = builder)
    }

    fun navigateBack() {
        navController.popBackStack()
    }

    fun navigateBack(
        destination: Destination,
        inclusive: Boolean = false,
        saveState: Boolean = false
    ) {
        navController.popBackStack<DashboardDestinations.Home>(
            inclusive = inclusive,
            saveState = saveState
        )
    }

    inline fun <reified T> navigateBackWithResult(key: String, value: T) {
        navController.previousBackStackEntry?.savedStateHandle?.set(
            key = key,
            value = value
        )
        navController.popBackStack()
    }
}

@Composable
fun rememberAppState(
    navHostController: NavHostController = rememberNavController(),
    toolbarManager: ToolbarManager = ToolbarManager
): AppState {
    return remember(navHostController) {
        AppState(navController = navHostController, toolbarManager = toolbarManager)
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED
