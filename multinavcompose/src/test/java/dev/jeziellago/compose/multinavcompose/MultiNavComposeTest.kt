package dev.jeziellago.compose.multinavcompose

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.slot
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class MultiNavComposeTest {

    private val moduleA = NavComposableModule { graph, navController ->
        graph.composable("module-a") {}
    }

    @Test
    fun `loadMultiNavComposables should call NavGraphBuilder loading composables or navigation `() {
        // Given
        val navController = mockk<NavHostController>(relaxed = true)
        val navGraphBuilder = mockk<NavGraphBuilder>(relaxed = true)
        val expectedRoute = "module-a"
        val expectedNavModules = listOf(moduleA)
        multiNavModules(moduleA)

        mockkStatic("androidx.navigation.compose.NavGraphBuilderKt")
        every {
            navGraphBuilder.composable(
                any(),
                any(),
                any(),
                any(),
            )
        } returns Unit

        // When
        navGraphBuilder.loadMultiNavComposables(navController)

        // Then
        val route = slot<String>()
        verify {
            navGraphBuilder.composable(
                capture(route),
                any(),
                any(),
                any(),
            )
        }
        assertEquals("Route", expectedRoute, route.captured)
        val modules = getNavComposableModulesFromGraph(APP_GRAPH_NAME)
        assertEquals("NavComposableModules", expectedNavModules, modules)
    }
}
