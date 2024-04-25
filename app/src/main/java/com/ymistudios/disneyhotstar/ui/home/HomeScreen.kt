package com.ymistudios.disneyhotstar.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.ymistudios.disneyhotstar.R
import com.ymistudios.disneyhotstar.data.pojo.movie.Movie
import com.ymistudios.disneyhotstar.data.pojo.movie.MoviePoster
import com.ymistudios.disneyhotstar.di.module.injectNavigator
import com.ymistudios.disneyhotstar.domain.navigator.Navigator
import com.ymistudios.disneyhotstar.ui.components.Icon
import com.ymistudios.disneyhotstar.ui.components.IconButton
import com.ymistudios.disneyhotstar.ui.components.Text
import com.ymistudios.disneyhotstar.ui.components.movie.MoviePoster
import com.ymistudios.disneyhotstar.ui.navigation.destinations.DashboardDestinations
import com.ymistudios.disneyhotstar.ui.theme.AppTheme
import com.ymistudios.disneyhotstar.ui.toolbarmanager.Toolbar
import com.ymistudios.disneyhotstar.ui.toolbarmanager.ToolbarManager
import com.ymistudios.disneyhotstar.utils.constants.DummyUrls
import com.ymistudios.disneyhotstar.utils.extension.horizontalSpacing

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigator: Navigator = injectNavigator()
) {
    ToolbarManager.setUpToolbar(Toolbar(showToolbar = false))

    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    HomeScreenContent(
        movieList = uiState.movieList,
        onMoviePosterClick = {
            navigator.navigate(DashboardDestinations.MovieDetailsDestination())
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreenContent(
    movieList: List<Movie>,
    onMoviePosterClick: (moviePoster: MoviePoster) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background),
        contentPadding = PaddingValues(vertical = AppTheme.dimension.verticalSpacing)
    ) {
        item {
            ProfileImage()
        }

        stickyHeader {
            TopHeader()
        }

        movieList.forEach { movie ->
            item {
                MovieListHeader(movie)
            }

            item {
                MovieList(movie = movie, onMoviePosterClick = onMoviePosterClick)
            }
        }
    }
}

@Composable
private fun MovieList(movie: Movie, onMoviePosterClick: (moviePoster: MoviePoster) -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimension.default),
        contentPadding = PaddingValues(
            horizontal = AppTheme.dimension.horizontalSpacing
        )
    ) {
        items(movie.moviePosterList) { moviePoster ->
            MoviePoster(
                moviePoster = moviePoster,
                onClick = onMoviePosterClick
            )
        }
    }
}

@Composable
private fun MovieListHeader(movie: Movie) {
    Text(
        modifier = Modifier
            .padding(
                top = AppTheme.dimension.medium,
                bottom = AppTheme.dimension.default
            )
            .horizontalSpacing(),
        text = movie.header,
        style = AppTheme.typography.subTitle
    )
}

@Composable
private fun ProfileImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = AppTheme.dimension.marginExtraLarge)
    ) {
        AsyncImage(
            modifier = Modifier
                .horizontalSpacing()
                .size(AppTheme.dimension.sizeMedium)
                .clip(AppTheme.shapes.circle)
                .align(Alignment.TopEnd),
            model = DummyUrls.PROFILE,
            contentDescription = stringResource(R.string.content_description_profile),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun TopHeader() {
    Row(
        modifier = Modifier
            .background(AppTheme.colors.background)
            .horizontalSpacing()
            .padding(vertical = AppTheme.dimension.default),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.title_everything),
            style = AppTheme.typography.title
        )

        Icon(
            resId = R.drawable.ic_drop_down_arrow,
            contentDescription = stringResource(id = R.string.title_everything)
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { }) {
            Icon(
                resId = R.drawable.ic_search,
                contentDescription = stringResource(R.string.content_description_search)
            )
        }

        IconButton(
            modifier = Modifier.padding(start = AppTheme.dimension.default),
            onClick = { }
        ) {
            Icon(
                resId = R.drawable.ic_download,
                contentDescription = stringResource(R.string.content_description_download)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenContentPrev() {
    HomeScreenContent(movieList = emptyList(), onMoviePosterClick = {})
}
