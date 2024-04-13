package com.ymistudios.disneyhotstar.ui.navigation

import com.ymistudios.disneyhotstar.ui.navigation.destinations.Destination
import com.ymistudios.disneyhotstar.utils.getCamelCaseString

object RouteBuilder {

    fun buildBaseRoute(destination: Destination) = getCamelCaseString(destination)

    fun buildPlaceholderRoute(baseRoute: String, keys: List<String>) = buildString {
        append(baseRoute)
        keys.forEach {
            append("/{$it}")
        }
    }

    fun buildArgRoute(baseRoute: String, vararg values: Any) = buildString {
        append(baseRoute)
        values.forEach {
            append("/$it")
        }
    }
}