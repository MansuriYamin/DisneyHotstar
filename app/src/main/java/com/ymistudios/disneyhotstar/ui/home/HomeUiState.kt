package com.ymistudios.disneyhotstar.ui.home

import com.ymistudios.disneyhotstar.data.pojo.movie.MovieWithHeader

data class HomeUiState(
    val movieList: List<MovieWithHeader> = emptyList()
)