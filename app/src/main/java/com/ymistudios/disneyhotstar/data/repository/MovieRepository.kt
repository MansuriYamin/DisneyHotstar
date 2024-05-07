package com.ymistudios.disneyhotstar.data.repository

import com.ymistudios.disneyhotstar.data.pojo.movie.MovieWithHeader

interface MovieRepository {

    fun getMovies(): List<MovieWithHeader>
    fun getMovieList(): List<MovieWithHeader>
}