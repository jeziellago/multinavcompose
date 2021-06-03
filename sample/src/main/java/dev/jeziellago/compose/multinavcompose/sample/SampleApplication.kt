package dev.jeziellago.compose.multinavcompose.sample

import android.app.Application
import dev.jeziellago.compose.multinavcompose.module1.screenFirstNavModule
import dev.jeziellago.compose.multinavcompose.multiNavModules
import dev.jeziellago.compose.multinavcompose.samplemodule2.screenSecondNavModule

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Register all NavComposeModules
        multiNavModules(screenFirstNavModule, screenSecondNavModule)
    }
}