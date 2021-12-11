package com.example.composeworkshop.ui.main.tabs.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.composeworkshop.LoadState

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        val loadState: LoadState by viewModel.loadState.collectAsState()

        Search()

        when (loadState) {
            LoadState.Loading -> MainLoading()
            LoadState.Error -> TODO()
            LoadState.Succeed -> TODO()
        }
    }
}