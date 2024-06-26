package com.ymistudios.disneyhotstar.data.datasource

import com.ymistudios.disneyhotstar.data.database.MovieDatabase
import com.ymistudios.disneyhotstar.data.pojo.movie.Header
import com.ymistudios.disneyhotstar.data.pojo.movie.Movie
import com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster
import com.ymistudios.disneyhotstar.data.pojo.movie.MovieWithHeader
import com.ymistudios.disneyhotstar.data.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.abs

@Singleton
class MovieDataSource @Inject constructor() : MovieRepository {

    override fun getMovies(): List<MovieWithHeader> {
        return MovieDatabase.headers.map { header ->
            MovieWithHeader(
                header = header,
                moviePosterList = when (header.type) {
                    Header.Type.FOR_YOU -> getRandomMovies()
                    Header.Type.CONTINUE_WATCHING -> getContinueWatchingMovies()
                    Header.Type.POPULAR -> getPopularMovies()
                    Header.Type.FOR_KIDS -> getRandomMovies()
                    Header.Type.TRENDING -> getTrendingMovies()
                    Header.Type.LATEST_RELEASES -> getLatestMovies()
                }
            )
        }
    }

    override fun getMovieDetails(id: Int): Movie? {
        return MovieDatabase.movieList.find { it.id == id }
    }

    override fun getSimilarMovies(id: Int): List<MoviePoster> {
        val movie = getMovieDetails(id)
        return movie?.let {
            MovieDatabase.movieList.filter { otherMovie ->
                otherMovie.id != movie.id && (otherMovie.genre.any { it in movie.genre }
                        || otherMovie.year == movie.year
                        || otherMovie.parentalRating == movie.parentalRating
                        || areImdbRatingsApproxSame(otherMovie.imdbRating, movie.imdbRating))
            }.shuffled().toMoviePoster(12)
        } ?: emptyList()
    }

    private fun getRandomMovies() =
        MovieDatabase.movieList.shuffled().toMoviePoster()

    private fun getContinueWatchingMovies() =
        MovieDatabase.movieList.shuffled().take(5).toMoviePoster()

    private fun getPopularMovies() =
        MovieDatabase.movieList.shuffled().filter { it.imdbRating > 7.0 }
            .sortedByDescending { it.imdbRating }
            .toMoviePoster()

    private fun getTrendingMovies() =
        MovieDatabase.movieList
            .filter { it.imdbRating > 6.0 && it.year >= 2023 }
            .sortedByDescending { it.imdbRating }
            .toMoviePoster()

    private fun getLatestMovies() =
        MovieDatabase.movieList.filter { it.year > 2020 }.shuffled().toMoviePoster()

    private fun List<Movie>.toMoviePoster(n: Int = 10) = take(n).map { movie ->
        MoviePoster(
            id = movie.id,
            poster = movie.poster
        )
    }

    private fun areImdbRatingsApproxSame(
        imdbRating1: Double,
        imdbRating2: Double
    ): Boolean {
        return abs(imdbRating1 - imdbRating2) <= 0.5
    }
}