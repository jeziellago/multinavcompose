package dev.jeziellago.compose.multinavcompose

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

internal const val APP_GRAPH_NAME = "multinavcompose.AppNavGraph"

fun multiNavModules(
    vararg ncModules: NavComposableModule,
    graphName: () -> String = { APP_GRAPH_NAME }
) {
    require(ncModules.isNotEmpty()) { "At least one NavComposeModule is required." }
    MultiNavCompose.navComposableModules[graphName()] = ncModules.toList()
}

fun interface NavComposableModule {
    fun createNavComposables(graph: NavGraphBuilder, navController: NavHostController)
}
