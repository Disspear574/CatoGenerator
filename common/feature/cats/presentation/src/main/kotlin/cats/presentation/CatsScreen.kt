package cats.presentation

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.Sync
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cats.presentation.components.CatButton
import cats.presentation.components.CatImage
import cats.presentation.components.CatsTopBar
import ru.disspear574.cats.presentation.R

@Suppress("MagicNumber")
@Composable
fun CatsScreen(
    vm: CatsViewModel = viewModel()
) {
    val state by vm.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val hapticFeedback = LocalHapticFeedback.current
    val mMediaPlayer = MediaPlayer.create(context, R.raw.cat_sound)

    Scaffold(
        topBar = {
            CatsTopBar(title = "Генератор котов")
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CatImage(
                img = state.cat?.image
            )

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                CatButton(
                    title = "Создать кота",
                    image = Icons.Rounded.Sync,
                    onClick = vm::generateNewCat
                )
                Spacer(
                    modifier = Modifier.weight(0.1f)
                )
                CatButton(
                    title = "Погладить кота",
                    image = Icons.Rounded.Pets,
                    onClick = {
                        mMediaPlayer.start()
                        hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (state.cat == null) state.error?.let { it1 -> Text(it1) }
        }
    }
}
