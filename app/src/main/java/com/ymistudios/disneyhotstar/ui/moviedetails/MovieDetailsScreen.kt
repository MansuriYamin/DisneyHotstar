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
    LaunchedEffect(key1 = Unit) {
        movieDetailsViewModel.onEvent(MovieDetailsEvent.GetMovieDetails(movieDetails.id))
    }

    val uiState by movieDetailsViewModel.uiState.collectAsStateWithLifecycle()

    with(sharedTransitionScope) {
        MovieDetailsScreenContent(
            movie = uiState.movie,
            sharedElement = {
                sharedElement(
                    state = sharedTransitionScope.rememberSharedContentState(key = movieDetails.sharedElementKey),
                    animatedVisibilityScope = animatedContentScope
                )
            },
            onClose = { navigator.navigateBack() }
        )
    }
}

@Composable
private fun MovieDetailsScreenContent(
    movie: Movie?,
    sharedElement: @Composable Modifier.() -> Modifier = { Modifier },
    onClose: () -> Unit
) {
    movie?.let {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.colors.background),
            contentPadding = PaddingValues(bottom = AppTheme.dimension.medium)
        ) {
            item {
                MovieHeader(
                    poster = movie.poster,
                    sharedElement = sharedElement,
                    onClose = onClose
                )
                MovieBasicInfo(
                    year = movie.year,
                    duration = movie.duration,
                    parentalRating = movie.parentalRating
                )
                MovieNameAndDescription(
                    name = movie.title,
                    imdbRating = movie.imdbRating,
                    description = movie.description,
                    genre = movie.genre
                )
                SimilarMovies()
            }
        }
    }
}

@Composable
private fun MovieHeader(
    poster: String,
    sharedElement: @Composable Modifier.() -> Modifier = { Modifier },
    onClose: () -> Unit
) {
    Box {
        AsyncImage(
            modifier = Modifier
                .sharedElement()
                .fillMaxWidth()
                .aspectRatio(2 / 3f)
                .clip(AppTheme.shapes.bottomRoundedCorners),
            model = poster,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
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
    year: Int,
    duration: String,
    parentalRating: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = AppTheme.dimension.medium),
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
    name: String,
    imdbRating: Double,
    description: String,
    genre: List<String>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = AppTheme.dimension.medium)
            .horizontalSpacing(),
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
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name,
                    style = AppTheme.typography.title,
                    color = White
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
                modifier = Modifier.padding(top = AppTheme.dimension.medium),
                text = description,
                textAlign = TextAlign.Center,
                style = AppTheme.typography.subTitle,
                color = White
            )

            Text(
                modifier = Modifier.padding(top = AppTheme.dimension.medium),
                text = genre.joinToString(),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.subTitle,
                color = White.copy(alpha = 0.4f)
            )

            LazyRow(
                modifier = Modifier.padding(top = AppTheme.dimension.large),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimension.medium)
            ) {
                items(5) {
                    Trailer()
                }
            }
        }
    }
}

@Composable
private fun Trailer() {
    Box {
        AsyncImage(
            modifier = Modifier
                .width(AppTheme.dimension.trailerWidth)
                .aspectRatio(16 / 9f)
                .clip(AppTheme.shapes.roundedCorners),
            model = "https://i.pinimg.com/236x/aa/39/57/aa39574b40081259b8b674dcc78c86d3.jpg",
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

            Text("2:05", style = AppTheme.typography.subTitle, color = White.copy(alpha = 0.6f))
        }
    }
}

@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun SimilarMovies() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = AppTheme.dimension.small)
            .horizontalSpacing(),
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

            val itemSize =
                ((LocalConfiguration.current.screenWidthDp.dp - (AppTheme.dimension.default * 2) - (AppTheme.dimension.medium * 2) - (AppTheme.dimension.horizontalSpacing * 2) - AppTheme.dimension.extraSmall) / 3)
            FlowRow(
                modifier = Modifier.padding(top = AppTheme.dimension.large),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimension.default),
                verticalArrangement = Arrangement.spacedBy(AppTheme.dimension.default)
            ) {
                (0..11).map {
                    MoviePoster(
                        moviePoster = com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster(
                            poster = "https://i.pinimg.com/236x/bf/0f/53/bf0f539e1d82d62725911e2b75056f46.jpg"
                        ),
                        width = itemSize,
                        onClick = {}
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MovieDetailsScreenPrev() {
    MovieDetailsScreenContent(
        movie = null,
        onClose = {}
    )
}
