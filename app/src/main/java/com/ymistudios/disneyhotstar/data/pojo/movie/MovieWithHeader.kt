package com.ymistudios.disneyhotstar.data.pojo.movie

import androidx.compose.runtime.Immutable

@Immutable
data class MovieWithHeader(
    val header: Header,
    val moviePosterList: List<MoviePoster>
)