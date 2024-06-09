package com.ymistudios.disneyhotstar.ui.moviedetails

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.ymistudios.disneyhotstar.R
import com.ymistudios.disneyhotstar.data.pojo.movie.Movie
import com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster
import com.ymistudios.disneyhotstar.data.pojo.movie.Trailer
import com.ymistudios.disneyhotstar.di.module.injectNavigator
import com.ymistudios.disneyhotstar.domain.navigator.Navigator
import com.ymistudios.disneyhotstar.ui.components.Icon
import com.ymistudios.disneyhotstar.ui.components.IconButton
import com.ymistudios.disneyhotstar.ui.components.Text
import com.ymistudios.disneyhotstar.ui.components.button.Button
import com.ymistudios.disneyhotstar.ui.components.movie.MoviePoster
import com.ymistudios.disneyhotstar.ui.navigation.destinations.DashboardDestinations
import com.ymistudios.disneyhotstar.ui.theme.AppTheme
import com.ymistudios.disneyhotstar.ui.theme.Black
import com.ymistudios.disneyhotstar.ui.theme.White
import com.ymistudios.disneyhotstar.utils.extension.horizontalSpacing

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MovieDetailsScreen(
    navigator: Navigator = injectNavigator(),
    movieDetailsViewModel: MovieDetailsViewModel = hiltViewModel(),
    movieDetails: DashboardDestinations.MovieDetails,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    LaunchedEffect(Unit) {
        movieDetailsViewModel.onEvent(MovieDetailsEvent.GetMovieDetails(movieDetails.id))
    }

    val uiState by movieDetailsViewModel.uiState.collectAsStateWithLifecycle()

    with(sharedTransitionScope) {
        MovieDetailsScreenContent(
            movie = uiState.movie,
            similarMovies = uiState.similarMovies,
            detailsSharedElement = {
                sharedElement(
                    state = sharedTransitionScope.rememberSharedContentState(key = movieDetails.sharedElementKey),
                    animatedVisibilityScope = animatedContentScope
                )
            },
            similarMovieSharedElement = { sharedElementKey ->
                sharedElement(
                    state = sharedTransitionScope.rememberSharedContentState(key = sharedElementKey),
                    animatedVisibilityScope = animatedContentScope
                )
            },
            onMoviePosterClick = { moviePoster, sharedElementKey ->
                navigator.navigate(
                    DashboardDestinations.MovieDetails(
                        id = moviePoster.id,
                        image = moviePoster.poster,
                        sharedElementKey = sharedElementKey
                    )
                )
            },
            onClose = { navigator.navigateBack() }
        )
    }
}

@Composable
private fun MovieDetailsScreenContent(
    movie: Movie?,
    similarMovies: List<MoviePoster>,
    detailsSharedElement: @Composable Modifier.() -> Modifier = { Modifier },
    similarMovieSharedElement: @Composable Modifier.(sharedElementKey: String) -> Modifier = { Modifier },
    onMoviePosterClick: (moviePoster: MoviePoster, sharedElementKey: String) -> Unit,
    onClose: () -> Unit
) {
    movie?.let {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.colors.background)
                .testTag("movieDetailsLazyColumn"),
            contentPadding = PaddingValues(bottom = AppTheme.dimension.medium)
        ) {
            item {
                MovieHeader(
                    poster = movie.poster,
                    detailsSharedElement = detailsSharedElement,
                    onClose = onClose
                )

                MovieBasicInfo(
                    modifier = Modifier.padding(top = AppTheme.dimension.medium),
                    year = movie.year,
                    duration = movie.duration,
                    parentalRating = movie.parentalRating
                )

                MovieNameAndDescription(
                    modifier = Modifier
                        .padding(top = AppTheme.dimension.medium)
                        .horizontalSpacing(),
                    name = movie.title,
                    imdbRating = movie.imdbRating,
                    description = movie.description,
                    genre = movie.genre,
                    trailers = movie.trailers
                )

                SimilarMovies(
                    modifier = Modifier
                        .padding(top = AppTheme.dimension.small)
                        .horizontalSpacing(),
                    movieId = movie.id,
                    similarMovies = similarMovies,
                    similarMovieSharedElement = similarMovieSharedElement,
                    onMoviePosterClick = onMoviePosterClick
                )
            }
        }
    }
}

@Composable
private fun MovieHeader(
    poster: String,
    detailsSharedElement: @Composable Modifier.() -> Modifier = { Modifier },
    onClose: () -> Unit
) {
    Box {
        AsyncImage(
            modifier = Modifier
                .detailsSharedElement()
                .fillMaxWidth()
                .aspectRatio(2 / 3f)
                .clip(AppTheme.shapes.bottomRoundedCorners),
            model = poster,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.content_description_movie_poster),
        )

        IconButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(
                    top = AppTheme.dimension.medium,
                    end = AppTheme.dimension.medium
                ),
            onClick = onClose
        ) {
            Icon(
                resId = R.drawable.ic_close,
                contentDescription = stringResource(id = R.string.content_description_close)
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(
                    bottom = AppTheme.dimension.medium,
                )
                .padding(
                    horizontal = AppTheme.dimension.medium
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = stringResource(id = R.string.button_play)
                )
                Text(
                    modifier = Modifier.padding(start = AppTheme.dimension.small),
                    text = stringResource(id = R.string.button_play),
                    color = Color.Unspecified
                )
            }

            IconButton(
                modifier = Modifier.padding(start = AppTheme.dimension.default),
                onClick = { }
            ) {
                Icon(resId = R.drawable.ic_add, contentDescription = "Add")
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                modifier = Modifier.padding(start = AppTheme.dimension.default),
                onClick = { }
            ) {
                Icon(resId = R.drawable.ic_more, contentDescription = "More")
            }
        }
    }
}

@Composable
private fun MovieBasicInfo(
    modifier: Modifier = Modifier,
    year: Int,
    duration: String,
    parentalRating: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = year.toString(),
            color = White.copy(alpha = 0.4f),
            style = AppTheme.typography.subTitle
        )
        Box(
            modifier = Modifier
                .padding(start = AppTheme.dimension.default)
                .size(AppTheme.dimension.extraSmall)
                .clip(AppTheme.shapes.circle)
                .background(White.copy(alpha = 0.4f))
        )
        Text(
            modifier = Modifier.padding(start = AppTheme.dimension.default),
            text = duration,
            color = White.copy(alpha = 0.4f),
            style = AppTheme.typography.subTitle
        )
        Box(
            modifier = Modifier
                .padding(start = AppTheme.dimension.default)
                .size(AppTheme.dimension.extraSmall)
                .background(White.copy(alpha = 0.4f))
        )
        Text(
            modifier = Modifier.padding(start = AppTheme.dimension.default),
            text = parentalRating,
            color = White.copy(alpha = 0.4f),
            style = AppTheme.typography.subTitle
        )
        Box(
            modifier = Modifier
                .padding(start = AppTheme.dimension.default)
                .size(AppTheme.dimension.extraSmall)
                .background(White.copy(alpha = 0.4f))
        )
        Text(
            modifier = Modifier.padding(start = AppTheme.dimension.default),
            text = "CC",
            color = White.copy(alpha = 0.4f),
            style = AppTheme.typography.subTitle
        )
        Box(
            modifier = Modifier
                .padding(start = AppTheme.dimension.default)
                .size(AppTheme.dimension.extraSmall)
                .background(White.copy(alpha = 0.4f))
        )
        Text(
            modifier = Modifier.padding(start = AppTheme.dimension.default),
            text = "HD",
            color = White.copy(alpha = 0.4f),
            style = AppTheme.typography.subTitle
        )
    }
}

@Composable
private fun MovieNameAndDescription(
    modifier: Modifier = Modifier,
    name: String,
    imdbRating: Double,
    description: String,
    genre: List<String>,
    trailers: List<Trailer>
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = AppTheme.shapes.roundedCornersExtraLarge,
        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.card)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = AppTheme.dimension.extraLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(horizontal = AppTheme.dimension.medium),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(weight = 1f, fill = false),
                    text = name,
                    style = AppTheme.typography.title,
                    color = White,
                    textAlign = TextAlign.Center
                )
                Box(
                    modifier = Modifier
                        .padding(start = AppTheme.dimension.default)
                        .clip(AppTheme.shapes.roundedCornersSmall)
                        .background(Color(0xFFD6AA26))
                        .padding(
                            horizontal = AppTheme.dimension.small,
                            vertical = AppTheme.dimension.extraSmall
                        )
                ) {
                    Text(
                        text = "IMDb",
                        style = AppTheme.typography.subTitle.copy(fontWeight = FontWeight.Bold),
                        color = Black
                    )
                }
                Text(
                    modifier = Modifier.padding(start = AppTheme.dimension.small),
                    text = imdbRating.toString()
                )
            }

            Text(
                modifier = Modifier
                    .padding(top = AppTheme.dimension.medium)
                    .padding(horizontal = AppTheme.dimension.medium),
                text = description,
                textAlign = TextAlign.Center,
                style = AppTheme.typography.subTitle,
                color = White
            )

            Text(
                modifier = Modifier
                    .padding(top = AppTheme.dimension.medium)
                    .padding(horizontal = AppTheme.dimension.medium),
                text = genre.joinToString(),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.subTitle,
                color = White.copy(alpha = 0.4f)
            )

            TrailerList(
                modifier = Modifier
                    .padding(top = AppTheme.dimension.large)
                    .align(Alignment.Start),
                trailers = trailers
            )
        }
    }
}

@Composable
private fun Trailer(trailer: Trailer) {
    Box {
        AsyncImage(
            modifier = Modifier
                .width(AppTheme.dimension.trailerWidth)
                .aspectRatio(16 / 9f)
                .clip(AppTheme.shapes.roundedCorners),
            model = trailer.thumbnail,
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = AppTheme.dimension.default, start = AppTheme.dimension.default)
                .background(
                    Black.copy(alpha = 0.6f),
                    shape = AppTheme.shapes.roundedCornersSmall
                )
                .padding(
                    horizontal = AppTheme.dimension.default,
                    vertical = AppTheme.dimension.small
                ),
            horizontalArrangement = Arrangement.spacedBy(AppTheme.dimension.small),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Trailer",
                style = AppTheme.typography.subTitle.copy(fontWeight = FontWeight.Bold),
                color = White
            )

            Box(
                modifier = Modifier
                    .size(AppTheme.dimension.extraSmall)
                    .background(White.copy(alpha = 0.6f))
            )

            Text(
                trailer.duration,
                style = AppTheme.typography.subTitle,
                color = White.copy(alpha = 0.6f)
            )
        }
    }
}

@Composable
private fun TrailerList(modifier: Modifier = Modifier, trailers: List<Trailer>) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimension.medium),
        contentPadding = PaddingValues(horizontal = AppTheme.dimension.medium)
    ) {
        items(trailers) { trailer ->
            Trailer(trailer = trailer)
        }
    }
}

@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun SimilarMovies(
    modifier: Modifier = Modifier,
    movieId: Int,
    similarMovies: List<MoviePoster>,
    similarMovieSharedElement: @Composable Modifier.(sharedElementKey: String) -> Modifier = { Modifier },
    onMoviePosterClick: (moviePoster: MoviePoster, sharedElementKey: String) -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = AppTheme.shapes.roundedCornersExtraLarge,
        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.card)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = AppTheme.dimension.extraLarge,
                    horizontal = AppTheme.dimension.medium
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "More like this",
                style = AppTheme.typography.title
            )

            val itemWidth =
                ((LocalConfiguration.current.screenWidthDp.dp - (AppTheme.dimension.default * 2) - (AppTheme.dimension.medium * 2) - (AppTheme.dimension.horizontalSpacing * 2) - AppTheme.dimension.extraSmall) / 3)
            FlowRow(
                modifier = Modifier.padding(top = AppTheme.dimension.large),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimension.default),
                verticalArrangement = Arrangement.spacedBy(AppTheme.dimension.default)
            ) {
                similarMovies.mapIndexed { index, moviePoster ->
                    val sharedElementKey = "similarMovie-$index-${moviePoster.id}-$movieId"
                    MoviePoster(
                        modifier = Modifier.similarMovieSharedElement(sharedElementKey),
                        moviePoster = moviePoster,
                        width = itemWidth,
                        onClick = { clickedMoviePoster ->
                            onMoviePosterClick(clickedMoviePoster, sharedElementKey)
                        }
                    )
                }
            }
        }
    }
}

/*
* ****************************************
* Previews
* ****************************************
* */

@Preview
@Composable
private fun MovieDetailsScreenPrev() {
    MovieDetailsScreenContent(
        movie = Movie(
            id = 1,
            title = "Zootopia",
            description = "Description of Zootopia",
            year = 2004,
            genre = listOf("Family", "Comedy", "Mystery"),
            duration = "1h 47min",
            imdbRating = 2.3,
            poster = "",
            trailers = listOf(
                Trailer(
                    id = 1,
                    thumbnail = "",
                    duration = "1min 35sec"
                )
            ),
            parentalRating = "PG"
        ),
        similarMovies = emptyList(),
        onMoviePosterClick = { _, _ -> },
        onClose = {}
    )
}

@Preview
@Composable
private fun MovieHeaderPrev() {
    MovieHeader(poster = "", onClose = {})
}

@Preview
@Composable
private fun MovieBasicInfoPrev() {
    MovieBasicInfo(year = 2024, duration = "1h 47min", parentalRating = "PG")
}

@Preview
@Composable
private fun MovieNameAndDescriptionPrev() {
    MovieNameAndDescription(
        name = "Zootopia",
        imdbRating = 2.3,
        description = "Description of Zootopia",
        genre = listOf("Family", "Comedy", "Mystery"),
        trailers = emptyList()
    )
}

@Preview
@Composable
private fun TrailerListPrev() {
    TrailerList(trailers = emptyList())
}

@Preview
@Composable
private fun SimilarMoviesPrev() {
    SimilarMovies(similarMovies = emptyList(), movieId = 1,onMoviePosterClick = { _, _ -> })
}
