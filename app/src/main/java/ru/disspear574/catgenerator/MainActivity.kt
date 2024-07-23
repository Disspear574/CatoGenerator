package ru.disspear574.catgenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cats.presentation.CatsScreen
import dagger.hilt.android.AndroidEntryPoint
import ru.disspear574.catgenerator.ui.theme.CatoGeneratorTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CatoGeneratorTheme {
                CatsScreen()
            }
        }
    }
}
