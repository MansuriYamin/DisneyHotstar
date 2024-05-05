package com.ymistudios.disneyhotstar.ui

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.serialization.generateRouteWithArgs
import com.ymistudios.disneyhotstar.R
import com.ymistudios.disneyhotstar.di.module.injectNavigator
import com.ymistudios.disneyhotstar.domain.navigator.NavigationAction
import com.ymistudios.disneyhotstar.domain.navigator.Navigator
import com.ymistudios.disneyhotstar.ui.components.Scaffold
import com.ymistudios.disneyhotstar.ui.components.Toolbar
import com.ymistudios.disneyhotstar.ui.navigation.NavHost
import com.ymistudios.disneyhotstar.ui.navigation.destinations.DashboardDestinations
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Destination
import com.ymistudios.disneyhotstar.ui.navigation.navgraphs.dashboardNavGraph
import com.ymistudios.disneyhotstar.ui.theme.AppTheme
import com.ymistudios.disneyhotstar.ui.toolbarmanager.Toolbar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.reflect.javaType
import kotlin.reflect.typeOf

@Composable
fun App(
    appViewModel: AppViewModel = hiltViewModel(),
    navigator: Navigator = injectNavigator()
) {
    AppTheme {
        val appState = rememberAppState()
        val toolbarState by appState.toolbarManager.toolbarState.collectAsStateWithLifecycle()

        AppNavigation(
            navigationActionFlow = appViewModel.navigationActionFlow,
            appState = appState
        )

        Scaffold(
            topBar = {
                AnimatedVisibility(
                    visible = toolbarState.showToolbar,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    Toolbar(
                        toolbarState = toolbarState,
                        onBackPressed = {
                            navigator.navigateBack()
                        }
                    )
                }
            }
        ) {
            NavHost(
                navController = appState.navController,
                startDestination = DashboardDestinations
            ) {
                dashboardNavGraph()
            }
        }
    }
}

@Composable
private fun AppNavigation(
    navigationActionFlow: Flow<NavigationAction>,
    appState: AppState
) {
    LaunchedEffect(Unit) {
        navigationActionFlow.onEach { navigationAction ->
            when (navigationAction) {
                is NavigationAction.NavigateTo -> {
                    appState.navigate(
                        destination = navigationAction.destination,
                        onlyIfResumed = navigationAction.onlyIfResumed,
                        builder = navigationAction.builder
                    )
                }

                is NavigationAction.NavigateBack -> {
                    navigationAction.destination?.let { destination ->
                        appState.navigateBack(
                            destination = destination,
                            inclusive = navigationAction.inclusive,
                            saveState = navigationAction.saveState
                        )
                    } ?: run {
                        appState.navigateBack()
                    }
                }

                is NavigationAction.NavigateBackWithResult<*> -> {
                    appState.navigateBackWithResult(
                        key = navigationAction.key,
                        value = navigationAction.value
                    )
                }
            }
        }.launchIn(this)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    toolbarState: Toolbar,
    onBackPressed: () -> Unit
) {
    Toolbar(
        title = {
            Text(text = toolbarState.toolbarTitle)
        },
        actions = {
            toolbarState.menuItems.forEach {
                IconButton(onClick = { it.onClick() }) {
                    Icon(painter = it.icon, contentDescription = "")
                }
            }
        },
        navigationIcon = {
            if (toolbarState.showBackButton) {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = null
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = toolbarState.toolbarBackgroundColor)
    )
}
