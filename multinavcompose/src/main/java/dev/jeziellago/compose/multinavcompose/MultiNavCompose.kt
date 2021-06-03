package dev.jeziellago.compose.multinavcompose

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.loadMultiNavComposables(
    navController: NavHostController,
    navComposableModules: List<NavComposableModule> = MultiNavCompose.navComposableModules
) {
    navComposableModules.forEach { module ->
        module.createNavComposables(this, navController)
    }
}

internal object MultiNavCompose {
    val navComposableModules = mutableListOf<NavComposableModule>()
}
