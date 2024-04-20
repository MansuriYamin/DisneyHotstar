package com.ymistudios.disneyhotstar.data.repository

import com.ymistudios.disneyhotstar.data.pojo.movie.Movie

interface MovieRepository {

    fun getMovieList(): List<Movie>
}