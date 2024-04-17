package com.ymistudios.disneyhotstar.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.ymistudios.disneyhotstar.R
import com.ymistudios.disneyhotstar.di.module.injectNavigator
import com.ymistudios.disneyhotstar.domain.navigator.Navigator
import com.ymistudios.disneyhotstar.ui.components.Icon
import com.ymistudios.disneyhotstar.ui.components.IconButton
import com.ymistudios.disneyhotstar.ui.components.Text
import com.ymistudios.disneyhotstar.ui.theme.AppTheme
import com.ymistudios.disneyhotstar.ui.toolbarmanager.Toolbar
import com.ymistudios.disneyhotstar.ui.toolbarmanager.ToolbarManager
import com.ymistudios.disneyhotstar.utils.constants.DummyUrls

@Composable
fun HomeScreen(navigator: Navigator = injectNavigator()) {
    ToolbarManager.setUpToolbar(Toolbar(showToolbar = false))

    HomeScreenContent()
}

@Composable
private fun HomeScreenContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background),
        contentPadding = PaddingValues(
            horizontal = AppTheme.dimension.horizontalSpacing,
            vertical = AppTheme.dimension.verticalSpacing
        )
    ) {
        item {
            Box(modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    modifier = Modifier
                        .size(AppTheme.dimension.sizeMedium)
                        .clip(AppTheme.shapes.circle)
                        .align(Alignment.TopEnd),
                    model = DummyUrls.PROFILE,
                    contentDescription = stringResource(R.string.content_description_profile),
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                modifier = Modifier.padding(top = AppTheme.dimension.marginLarge),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.title_everything),
                    style = AppTheme.typography.titleLarge
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
                    modifier = Modifier.padding(start = AppTheme.dimension.marginSmall),
                    onClick = { }
                ) {
                    Icon(
                        resId = R.drawable.ic_download,
                        contentDescription = stringResource(R.string.content_description_download)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenContentPrev() {
    HomeScreenContent()
}
