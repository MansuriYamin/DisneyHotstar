package com.ymistudios.disneyhotstar.ui.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Destination

fun NavGraphBuilder.composable(
    destination: Destination,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = destination.route,
        arguments = destination.arguments,
        content = content
    )
}

fun NavGraphBuilder.navigation(
    destination: Destination,
    startDestination: Destination,
    builder: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = startDestination.route,
        route = destination.route,
        builder = builder
    )
}

fun navArgument(vararg pairs: Pair<String, NavType<*>>): List<NamedNavArgument> {
    return pairs.map { navArgument(it.first) { type = it.second } }
}