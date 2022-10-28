@file:OptIn(ExperimentalFoundationApi::class)

package cz.itnetwork.urbysoundboard
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.itnetwork.urbysoundboard.models.Sound
import cz.itnetwork.urbysoundboard.ui.theme.UrbySoundboardTheme

class MainActivity : ComponentActivity() {
    val mp = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UrbySoundboardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SoundButtonGrid(sounds = Sound.getSounds(LocalContext.current), callback = {
                        playSound(it)
                    })
                }
            }
        }
    }

    private fun playSound(id: Int) {
        with(mp) {
            reset()
            setDataSource(resources.openRawResourceFd(id))
            prepare()
            start()
        }

    }
}

@Composable
fun SoundButtonGrid(sounds: List<Sound>, callback: (Int) -> Unit = {}) {
    LazyVerticalGrid(cells = GridCells.Adaptive(128.dp)) {
        items(sounds) {
            SoundButton(sound = it, callback = callback, background = Color.Green)
        }
    }
}

@Composable
fun SoundButton(
    modifier: Modifier = Modifier,
    sound: Sound,
    background: Color = Color.Transparent,
    callback: (Int) -> Unit = {}) {
    Box(modifier = modifier
        .padding(4.dp)
        .aspectRatio(1f)
        .clip(RoundedCornerShape(5.dp))
        .background(color = background)
        .clickable { callback(sound.id) },

    ) {
        Text(text = sound.name, modifier = Modifier.align(Alignment.Center), textAlign = TextAlign.Center)
    }
}


@Preview
@Composable
fun TestGrid() {
    SoundButtonGrid(sounds = Sound.getSounds(LocalContext.current))
}