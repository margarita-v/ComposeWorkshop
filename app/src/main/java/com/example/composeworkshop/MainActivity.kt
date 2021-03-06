package com.example.composeworkshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import coil.annotation.ExperimentalCoilApi
import com.example.composeworkshop.ui.main.MainScreen
import com.example.composeworkshop.ui.theme.ComposeWorkshopTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWorkshopTheme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}