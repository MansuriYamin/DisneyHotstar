package com.ymistudios.disneyhotstar.ui.moviedetails

sealed class MovieDetailsEvent {
    data class GetMovieDetails(val id: Int) : MovieDetailsEvent()
}