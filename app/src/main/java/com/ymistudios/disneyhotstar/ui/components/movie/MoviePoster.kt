package com.ymistudios.disneyhotstar.ui.components.movie

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import com.ymistudios.disneyhotstar.R
import com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster
import com.ymistudios.disneyhotstar.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviePoster(
    moviePoster: MoviePoster,
    width: Dp = AppTheme.dimension.moviePosterWidth,
    onClick: (moviePoster: MoviePoster) -> Unit
) {
    Card(shape = AppTheme.shapes.card, onClick = { onClick(moviePoster) }) {
        AsyncImage(
            modifier = Modifier
                .width(width)
                .aspectRatio(2 / 3f),
            model = moviePoster.poster,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.content_description_movie_poster)
        )
    }
}

@Preview
@Composable
fun MoviePosterPrev() {
    MoviePoster(moviePoster = MoviePoster(poster = ""), onClick = {})
}
