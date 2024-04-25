package com.ymistudios.disneyhotstar.ui.navigation.navgraphs

import androidx.navigation.NavGraphBuilder
import com.ymistudios.disneyhotstar.ui.home.HomeScreen
import com.ymistudios.disneyhotstar.ui.moviedetails.MovieDetailsScreen
import com.ymistudios.disneyhotstar.ui.navigation.composable
import com.ymistudios.disneyhotstar.ui.navigation.destinations.DashboardDestinations
import com.ymistudios.disneyhotstar.ui.navigation.navigation

fun NavGraphBuilder.dashboardNavGraph() {
    navigation(
        destination = DashboardDestinations,
        startDestination = DashboardDestinations.HomeDestination
    ) {
        composable(DashboardDestinations.HomeDestination) {
            HomeScreen()
        }

        composable(DashboardDestinations.MovieDetailsDestination) {
            MovieDetailsScreen()
        }
    }
}