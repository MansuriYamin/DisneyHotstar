package com.ymistudios.disneyhotstar.ui.moviedetails

import com.ymistudios.disneyhotstar.data.pojo.movie.Movie
import com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster

data class MovieDetailsUiState(
    val movie: Movie? = null,
    val similarMovies: List<MoviePoster> = emptyList()
)