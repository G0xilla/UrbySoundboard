@file:OptIn(ExperimentalFoundationApi::class)

package cz.itnetwork.urbysoundboard

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cz.itnetwork.urbysoundboard.ui.theme.UrbySoundboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UrbySoundboardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UrbySoundboardTheme {
        Greeting("Android")
    }
}

@Composable
fun SoundButtonGrid(texts: List<String>) {
    LazyVerticalGrid(cells = GridCells.Adaptive(128.dp)) {
        items(texts) {

        }
    }
}

@Composable
fun SoundButton(modifier: Modifier = Modifier, size: Dp, text: String) {
    Box(modifier = modifier
        .width(size)
        .height(size),
    ) {
        Text(text = text, modifier = Modifier.align(Alignment.Center), textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun TestAlignment() {
    SoundButton(size = 48.dp, text = "hello")
}