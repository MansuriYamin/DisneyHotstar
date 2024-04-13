package com.ymistudios.disneyhotstar.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.rememberNavController
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Route
import com.ymistudios.disneyhotstar.ui.navigation.destinations.TAG_NAVIGATION
import com.ymistudios.disneyhotstar.ui.navigation.navigate
import com.ymistudios.disneyhotstar.ui.navigation.popBackStack
import com.ymistudios.disneyhotstar.ui.toolbarmanager.ToolbarManager

@Stable
class PicVerseAppState(
    val navController: NavHostController,
    val toolbarManager: ToolbarManager
) {

    fun navigate(
        route: Route,
        onlyIfResumed: Boolean = true,
        builder: NavOptionsBuilder.() -> Unit = {}
    ) {
        if (onlyIfResumed && navController.currentBackStackEntry?.lifecycleIsResumed() == false)
            return

        Log.d(TAG_NAVIGATION, "navigate: ${route.route}")
        navController.navigate(route = route, builder = builder)
    }

    fun navigateBack() {
        navController.popBackStack()
    }

    fun navigateBack(
        route: Route,
        inclusive: Boolean = false,
        saveState: Boolean = false
    ) {
        navController.popBackStack(route = route, inclusive = inclusive, saveState = saveState)
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
fun rememberPicVerseAppState(
    navHostController: NavHostController = rememberNavController(),
    toolbarManager: ToolbarManager = ToolbarManager
): PicVerseAppState {
    return remember(navHostController) {
        PicVerseAppState(navController = navHostController, toolbarManager = toolbarManager)
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED
