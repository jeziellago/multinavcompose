package dev.jeziellago.compose.multinavcompose.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.jeziellago.compose.multinavcompose.loadMultiNavComposables

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AppContent() }
    }

    @Composable
    fun AppContent() {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = MaterialTheme.colors.primary,
                    title = { Text(text = stringResource(id = R.string.app_name)) },
                )
            },
        ) {
            NavHost(navController = navController, startDestination = "screen-first") {
                loadMultiNavComposables(navController)
            }
        }
    }
}