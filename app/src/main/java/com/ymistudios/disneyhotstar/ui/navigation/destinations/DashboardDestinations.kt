package com.ymistudios.disneyhotstar.ui.navigation.destinations

import kotlinx.serialization.Serializable

@Serializable
data object DashboardDestinations : Destination {
    @Serializable
    data object Home : Destination

    @Serializable
    data class MovieDetails(val image: String, val id: Int, val sharedElementKey: String) : Destination
}