package com.ymistudios.disneyhotstar.ui.navigation.navgraphs

import androidx.navigation.NavGraphBuilder
import com.ymistudios.disneyhotstar.ui.home.HomeScreen
import com.ymistudios.disneyhotstar.ui.moviedetails.MovieDetailsScreen
import com.ymistudios.disneyhotstar.ui.navigation.composable
import com.ymistudios.disneyhotstar.ui.navigation.destinations.DashboardDestinations
import com.ymistudios.disneyhotstar.ui.navigation.navigation

fun NavGraphBuilder.dashboardNavGraph() {
    navigation<DashboardDestinations>(
        startDestination = DashboardDestinations.Home
    ) {
        composable<DashboardDestinations.Home> { _, _ ->
            HomeScreen()
        }

        composable<DashboardDestinations.MovieDetails> { _, movieDetails ->
            MovieDetailsScreen(movieDetails)
        }
    }
}