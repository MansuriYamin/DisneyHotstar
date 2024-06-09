package com.ymistudios.disneyhotstar.data.repository

import com.ymistudios.disneyhotstar.data.pojo.movie.Movie
import com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster
import com.ymistudios.disneyhotstar.data.pojo.movie.MovieWithHeader

interface MovieRepository {

    fun getMovies(): List<MovieWithHeader>

    fun getMovieDetails(id: Int): Movie?

    fun getSimilarMovies(id: Int): List<MoviePoster>
}