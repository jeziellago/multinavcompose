package dev.jeziellago.compose.multinavcompose.samplemodule2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun ScreenSampleSecond(message: String) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(text = "Screen Second! Received: $message")
    }
}
