package com.ymistudios.disneyhotstar.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.PopUpToBuilder
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Destination
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Route

fun NavController.navigate(
    route: Route,
    builder: NavOptionsBuilder.() -> Unit
) {
    navigate(route = route.route, builder = builder)
}

fun NavOptionsBuilder.popUpTo(
    destination: Destination,
    popUpToBuilder: PopUpToBuilder.() -> Unit = {}
) {
    // popUpTo(route = destination.route, popUpToBuilder = popUpToBuilder)
}

fun NavController.popBackStack(
    route: Route,
    inclusive: Boolean = false,
    saveState: Boolean = false
) {
    popBackStack(route = route.route, inclusive = inclusive, saveState = saveState)
}
