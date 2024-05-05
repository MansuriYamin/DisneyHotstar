package com.ymistudios.disneyhotstar.domain.navigator

import androidx.navigation.NavOptionsBuilder
import com.ymistudios.disneyhotstar.ui.navigation.destinations.Destination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultNavigator @Inject constructor() : Navigator {

    private val navigationActionChannel: Channel<NavigationAction> = Channel()
    override val navigationActionFlow: Flow<NavigationAction>
        get() = navigationActionChannel.receiveAsFlow()

    override fun navigate(
        destination: Destination,
        onlyIfResumed: Boolean,
        builder: NavOptionsBuilder.() -> Unit
    ) {
        navigationActionChannel.trySend(
            NavigationAction.NavigateTo(
                destination = destination,
                onlyIfResumed = onlyIfResumed,
                builder = builder
            )
        )
    }

    override fun navigateBack() {
        navigationActionChannel.trySend(NavigationAction.NavigateBack())
    }

    override fun navigateBack(
        destination: Destination,
        inclusive: Boolean,
        saveState: Boolean
    ) {
        navigationActionChannel.trySend(
            NavigationAction.NavigateBack(
                destination = destination,
                inclusive = inclusive,
                saveState = saveState
            )
        )
    }

    override fun <T> navigateBackWithResult(key: String, value: T?) {
        navigationActionChannel.trySend(
            NavigationAction.NavigateBackWithResult(
                key = key,
                value = value
            )
        )
    }
}