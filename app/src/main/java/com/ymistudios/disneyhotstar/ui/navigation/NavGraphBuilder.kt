package com.ymistudios.disneyhotstar.ui.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Destination

inline fun <reified T : Destination> NavGraphBuilder.composable(
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry, T) -> Unit
) {
    composable<T> {
        val args = it.toRoute<T>()
        content(it, args)
    }
}

inline fun <reified T : Destination> NavGraphBuilder.navigation(
    startDestination: Destination,
    builder: NavGraphBuilder.() -> Unit
) {
    navigation<T>(
        startDestination = startDestination,
        builder = builder
    )
}