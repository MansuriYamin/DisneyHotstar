package com.ymistudios.disneyhotstar.ui.components.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import com.ymistudios.disneyhotstar.R
import com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster
import com.ymistudios.disneyhotstar.ui.theme.AppTheme

@Composable
fun MoviePoster(
    moviePoster: MoviePoster,
    modifier: Modifier = Modifier,
    width: Dp = AppTheme.dimension.moviePosterWidth,
    onClick: (moviePoster: MoviePoster) -> Unit
) {
    AsyncImage(
        modifier = modifier
            .width(width)
            .aspectRatio(2 / 3f)
            .clip(AppTheme.shapes.roundedCorners)
            .clickable { onClick(moviePoster) },
        model = moviePoster.poster,
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(R.string.content_description_movie_poster)
    )
}

@Preview
@Composable
fun MoviePosterPrev() {
    MoviePoster(moviePoster = MoviePoster(poster = ""), onClick = {})
}
