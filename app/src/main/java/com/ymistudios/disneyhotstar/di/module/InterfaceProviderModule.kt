package com.ymistudios.disneyhotstar.di.module

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.ymistudios.disneyhotstar.domain.navigator.DefaultNavigator
import com.ymistudios.disneyhotstar.domain.navigator.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class InterfaceProviderModule {

    @Singleton
    @Binds
    abstract fun provideNavigator(defaultNavigator: DefaultNavigator): Navigator
}

private lateinit var navigatorEntryPoint: NavigatorEntryPoint

@EntryPoint
@InstallIn(SingletonComponent::class)
interface NavigatorEntryPoint {
    val navigator: Navigator
}

@Composable
fun injectNavigator(): Navigator {
    if (!::navigatorEntryPoint.isInitialized) {
        navigatorEntryPoint = EntryPoints.get(
            LocalContext.current.applicationContext,
            NavigatorEntryPoint::class.java
        )
    }

    return navigatorEntryPoint.navigator
}
