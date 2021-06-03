package dev.jeziellago.compose.multinavcompose.samplemodule2

import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import dev.jeziellago.compose.multinavcompose.NavComposableModule

private const val MESSAGE_ARG_KEY = "MESSAGE"

val screenSecondNavModule = NavComposableModule { graph, _ ->
    graph.composable(
        route = "screen-second/{$MESSAGE_ARG_KEY}",
        arguments = listOf(navArgument(MESSAGE_ARG_KEY) { type = NavType.StringType })
    ) { backStackEntry ->
        val message = checkNotNull(backStackEntry.arguments?.getString(MESSAGE_ARG_KEY))
        ScreenSampleSecond(message)
    }
}