package com.ymistudios.disneyhotstar.data.datasource

import com.ymistudios.disneyhotstar.data.database.MovieDatabase
import com.ymistudios.disneyhotstar.data.pojo.movie.Header
import com.ymistudios.disneyhotstar.data.pojo.movie.Movie
import com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster
import com.ymistudios.disneyhotstar.data.pojo.movie.MovieWithHeader
import com.ymistudios.disneyhotstar.data.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDataSource @Inject constructor() : MovieRepository {

    override fun getMovies(): List<MovieWithHeader> {
        return MovieDatabase.headers.map { header ->
            MovieWithHeader(
                header = header,
                moviePosterList = when (header.type) {
                    Header.Type.FOR_YOU -> getRandomMovies()
                    Header.Type.CONTINUE_WATCHING -> getRandomMovies()
                    Header.Type.POPULAR -> getPopularMovies()
                    Header.Type.FOR_KIDS -> getRandomMovies()
                    Header.Type.TRENDING -> getTrendingMovies()
                }
            )
        }
    }

    private fun getRandomMovies() =
        MovieDatabase.movieList.shuffled().toMoviePoster()

    private fun getPopularMovies() =
        MovieDatabase.movieList.filter { it.imdbRating > 7.0 }.toMoviePoster()

    private fun getTrendingMovies() =
        MovieDatabase.movieList.filter { it.imdbRating > 7.0 && it.year == 2024 }.toMoviePoster()

    private fun List<Movie>.toMoviePoster() = map { movie ->
        MoviePoster(
            id = movie.id,
            poster = movie.posterUrl
        )
    }.take(10)

    override fun getMovieList(): List<MovieWithHeader> {
        return emptyList()
        /*return listOf(
            MovieWithHeader(
                header = "For you",
                moviePosterList = listOf(
                    MoviePoster(
                        id = 0,
                        poster = "https://i.pinimg.com/736x/c0/89/7a/c0897a72abc0221eb67a99d744eaecf5.jpg"
                    ),
                    MoviePoster(
                        id = 1,
                        poster = "https://i.pinimg.com/736x/c6/ac/ed/c6aced5d39018cc4ce37ed055629afbf.jpg"
                    ),
                    MoviePoster(
                        id = 2,
                        poster = "https://i.pinimg.com/736x/aa/39/57/aa39574b40081259b8b674dcc78c86d3.jpg"
                    ),
                    MoviePoster(
                        id = 3,
                        poster = "https://i.pinimg.com/736x/d3/4a/e0/d34ae00081e8a203e1acfd360f0ae7f4.jpg"
                    )
                )
            ),
            MovieWithHeader(
                header = "Continue Watching",
                moviePosterList = listOf(
                    MoviePoster(
                        id = 4,
                        poster = "https://i.pinimg.com/736x/bf/0f/53/bf0f539e1d82d62725911e2b75056f46.jpg"
                    ),
                    MoviePoster(
                        id = 5,
                        poster = "https://i.pinimg.com/736x/fe/e6/a6/fee6a6f69e83c4eb9dfce93929c8ad2c.jpg"
                    ),
                    MoviePoster(
                        id = 6,
                        poster = "https://i.pinimg.com/736x/ae/1d/19/ae1d19b2368a16420ac1b864f4e9d6cd.jpg"
                    ),
                    MoviePoster(
                        id = 7,
                        poster = "https://i.pinimg.com/736x/a5/08/6b/a5086bb6940abc2d6301e7b1acc1aa6e.jpg"
                    )
                )
            ),
            MovieWithHeader(
                header = "Trending",
                moviePosterList = listOf(
                    MoviePoster(
                        id = 8,
                        poster = "https://i.pinimg.com/736x/23/75/4b/23754b0b1fc5d35c1ee3159ae7cf6acc.jpg"
                    ),
                    MoviePoster(
                        id = 9,
                        poster = "https://i.pinimg.com/736x/93/6d/de/936dde7cea710e5a3c8ab01e21c7a846.jpg"
                    ),
                    MoviePoster(
                        id = 10,
                        poster = "https://i.pinimg.com/736x/9d/c2/be/9dc2befdb05b1f43edc7b0147233f48b.jpg"
                    ),
                    MoviePoster(
                        id = 11,
                        poster = "https://i.pinimg.com/736x/3c/df/75/3cdf7598932e299868d447d6174332c6.jpg"
                    )
                )
            ),
            MovieWithHeader(
                header = "Trending",
                moviePosterList = listOf(
                    MoviePoster(
                        id = 12,
                        poster = "https://i.pinimg.com/736x/23/75/4b/23754b0b1fc5d35c1ee3159ae7cf6acc.jpg"
                    ),
                    MoviePoster(
                        id = 13,
                        poster = "https://i.pinimg.com/736x/93/6d/de/936dde7cea710e5a3c8ab01e21c7a846.jpg"
                    ),
                    MoviePoster(
                        id = 14,
                        poster = "https://i.pinimg.com/736x/9d/c2/be/9dc2befdb05b1f43edc7b0147233f48b.jpg"
                    ),
                    MoviePoster(
                        id = 15,
                        poster = "https://i.pinimg.com/736x/3c/df/75/3cdf7598932e299868d447d6174332c6.jpg"
                    )
                )
            ),
            MovieWithHeader(
                header = "Trending",
                moviePosterList = listOf(
                    MoviePoster(
                        id = 16,
                        poster = "https://i.pinimg.com/736x/23/75/4b/23754b0b1fc5d35c1ee3159ae7cf6acc.jpg"
                    ),
                    MoviePoster(
                        id = 17,
                        poster = "https://i.pinimg.com/736x/93/6d/de/936dde7cea710e5a3c8ab01e21c7a846.jpg"
                    ),
                    MoviePoster(
                        id = 18,
                        poster = "https://i.pinimg.com/736x/9d/c2/be/9dc2befdb05b1f43edc7b0147233f48b.jpg"
                    ),
                    MoviePoster(
                        id = 19,
                        poster = "https://i.pinimg.com/736x/3c/df/75/3cdf7598932e299868d447d6174332c6.jpg"
                    )
                )
            )
        )*/
    }
}