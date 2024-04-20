package com.ymistudios.disneyhotstar.data.datasource

import com.ymistudios.disneyhotstar.data.pojo.movie.Movie
import com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster
import com.ymistudios.disneyhotstar.data.repository.MovieRepository
import com.ymistudios.disneyhotstar.utils.constants.DummyUrls
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDataSource @Inject constructor() : MovieRepository {

    override fun getMovieList(): List<Movie> {
        return listOf(
            Movie(
                header = "For you",
                moviePosterList = listOf(
                    MoviePoster(poster = "https://i.pinimg.com/564x/c0/89/7a/c0897a72abc0221eb67a99d744eaecf5.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/c6/ac/ed/c6aced5d39018cc4ce37ed055629afbf.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/aa/39/57/aa39574b40081259b8b674dcc78c86d3.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/d3/4a/e0/d34ae00081e8a203e1acfd360f0ae7f4.jpg")
                )
            ),
            Movie(
                header = "Continue Watching",
                moviePosterList = listOf(
                    MoviePoster(poster = "https://i.pinimg.com/236x/bf/0f/53/bf0f539e1d82d62725911e2b75056f46.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/fe/e6/a6/fee6a6f69e83c4eb9dfce93929c8ad2c.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/ae/1d/19/ae1d19b2368a16420ac1b864f4e9d6cd.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/a5/08/6b/a5086bb6940abc2d6301e7b1acc1aa6e.jpg")
                )
            ),
            Movie(
                header = "Trending",
                moviePosterList = listOf(
                    MoviePoster(poster = "https://i.pinimg.com/236x/23/75/4b/23754b0b1fc5d35c1ee3159ae7cf6acc.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/93/6d/de/936dde7cea710e5a3c8ab01e21c7a846.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/9d/c2/be/9dc2befdb05b1f43edc7b0147233f48b.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/3c/df/75/3cdf7598932e299868d447d6174332c6.jpg")
                )
            ),
            Movie(
                header = "Trending",
                moviePosterList = listOf(
                    MoviePoster(poster = "https://i.pinimg.com/236x/23/75/4b/23754b0b1fc5d35c1ee3159ae7cf6acc.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/93/6d/de/936dde7cea710e5a3c8ab01e21c7a846.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/9d/c2/be/9dc2befdb05b1f43edc7b0147233f48b.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/3c/df/75/3cdf7598932e299868d447d6174332c6.jpg")
                )
            ),
            Movie(
                header = "Trending",
                moviePosterList = listOf(
                    MoviePoster(poster = "https://i.pinimg.com/236x/23/75/4b/23754b0b1fc5d35c1ee3159ae7cf6acc.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/93/6d/de/936dde7cea710e5a3c8ab01e21c7a846.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/9d/c2/be/9dc2befdb05b1f43edc7b0147233f48b.jpg"),
                    MoviePoster(poster = "https://i.pinimg.com/236x/3c/df/75/3cdf7598932e299868d447d6174332c6.jpg")
                )
            )
        )
    }
}