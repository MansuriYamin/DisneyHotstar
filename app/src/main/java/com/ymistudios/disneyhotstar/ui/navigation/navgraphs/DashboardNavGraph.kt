package com.ymistudios.disneyhotstar.ui.navigation.navgraphs

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import com.ymistudios.disneyhotstar.ui.home.HomeScreen
import com.ymistudios.disneyhotstar.ui.moviedetails.MovieDetailsScreen
import com.ymistudios.disneyhotstar.ui.navigation.composable
import com.ymistudios.disneyhotstar.ui.navigation.destinations.DashboardDestinations
import com.ymistudios.disneyhotstar.ui.navigation.navigation

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.DashboardNavGraph(sharedTransitionScope: SharedTransitionScope) {
        navigation<DashboardDestinations>(
            startDestination = DashboardDestinations.Home
        ) {
            composable<DashboardDestinations.Home> { _, _ ->
                HomeScreen(
                    sharedTransitionScope = sharedTransitionScope,
                    animatedContentScope = this@composable
                )
            }

            composable<DashboardDestinations.MovieDetails> { _, movieDetails ->
                MovieDetailsScreen(
                    movieDetails = movieDetails,
                    sharedTransitionScope = sharedTransitionScope,
                    animatedContentScope = this@composable
                )
            }
        }
}