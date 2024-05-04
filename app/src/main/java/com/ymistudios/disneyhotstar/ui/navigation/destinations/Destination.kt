package com.ymistudios.disneyhotstar.ui.navigation.destinations

import android.os.Bundle
import androidx.navigation.NamedNavArgument
import com.ymistudios.disneyhotstar.ui.navigation.RouteBuilder

const val TAG_NAVIGATION = "Navigation"

data class Route(
    val route: String
)

sealed interface Destination {
    /*val baseRoute
        get() = RouteBuilder.buildBaseRoute(this)
    val route: String

    val arguments: List<NamedNavArgument>*/
}

sealed class NoArgDestination : Destination {
    /*override*/ val route: String
        get() = "baseRoute"

    /*override*/ val arguments: List<NamedNavArgument>
        get() = emptyList()

    operator fun invoke(): Route = Route("baseRoute")
}

sealed class ArgDestination<T> : Destination {

    private val keys: List<String>
        get() = emptyList()//arguments.map { it.name }

    /*override*/ val route: String
        get() = RouteBuilder.buildPlaceholderRoute(baseRoute = "baseRoute", keys = keys)

    abstract operator fun invoke(data: T): Route

    abstract fun getArgs(bundle: Bundle?): T?

    fun buildArgRoute(vararg values: Any) =
        RouteBuilder.buildArgRoute(baseRoute = "baseRoute", *values)
}
