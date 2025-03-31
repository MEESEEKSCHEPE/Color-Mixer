package com.example.colormixer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorMixerApp()
        }
    }
}

@Composable
fun ColorMixerApp() {
    var red by remember { mutableStateOf(0f) }
    var green by remember { mutableStateOf(0f) }
    var blue by remember { mutableStateOf(0f) }

    val color = Color(red / 255f, green / 255f, blue / 255f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ColorPreview(color)
        Spacer(modifier = Modifier.height(16.dp))
        ColorSlider("Red", red) { red = it }
        ColorSlider("Green", green) { green = it }
        ColorSlider("Blue", blue) { blue = it }
    }
}

@Composable
fun ColorPreview(color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(8.dp)
            .background(color, shape = RoundedCornerShape(12.dp))
    )
}

@Composable
fun ColorSlider(label: String, value: Float, onValueChange: (Float) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = "$label: ${value.toInt()}", style = MaterialTheme.typography.bodyLarge)
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = 0f..255f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewColorMixer() {
    ColorMixerApp()
}
