package dev.jeziellago.compose.multinavcompose.module1

import androidx.navigation.compose.composable
import dev.jeziellago.compose.multinavcompose.NavComposableModule

val screenFirstNavModule = NavComposableModule { graph, navController ->
    graph.composable("screen-first") {
        ScreenSampleFirst(onClick = { message ->
            navController.navigate("screen-second/$message")
        })
    }
}