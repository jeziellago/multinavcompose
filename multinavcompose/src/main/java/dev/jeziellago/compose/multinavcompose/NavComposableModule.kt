package dev.jeziellago.compose.multinavcompose

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun multiNavModules(vararg ncModules: NavComposableModule) {
    MultiNavCompose.navComposableModules.addAll(ncModules)
}

fun interface NavComposableModule {
    fun createNavComposables(graph: NavGraphBuilder, navController: NavHostController)
}
