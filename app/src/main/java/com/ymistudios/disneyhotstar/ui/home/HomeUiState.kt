package com.ymistudios.disneyhotstar.ui.home

import com.ymistudios.disneyhotstar.data.pojo.movie.Movie

data class HomeUiState(
    val movieList: List<Movie> = emptyList()
)