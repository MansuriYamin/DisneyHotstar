package com.ymistudios.disneyhotstar.ui.components.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import com.ymistudios.disneyhotstar.R
import com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster
import com.ymistudios.disneyhotstar.ui.theme.AppTheme
import com.ymistudios.disneyhotstar.utils.sdp

@Composable
fun MoviePoster(
    moviePoster: MoviePoster,
    width: Dp = AppTheme.dimension.moviePosterWidth,
    sharedElement: @Composable Modifier.(String) -> Modifier = { Modifier },
    onClick: (moviePoster: MoviePoster) -> Unit
) {
    /*Box(modifier = Modifier
        //.sharedElement("image-${moviePoster.id}")
        .width(width)
        .aspectRatio(2 / 3f)
        .clip(AppTheme.shapes.roundedCorners)
        .background(Color.Red)
        .clickable { onClick(moviePoster) })*/
    AsyncImage(
        modifier = Modifier
            //.sharedElement("image-${moviePoster.id}")
            .width(width)
            .aspectRatio(2 / 3f)
            .clip(AppTheme.shapes.roundedCorners)
            .clickable { onClick(moviePoster) },
        model = moviePoster.poster,
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(R.string.content_description_movie_poster)
    )
}

@Preview
@Composable
fun MoviePosterPrev() {
    MoviePoster(moviePoster = MoviePoster(poster = ""), onClick = {})
}
