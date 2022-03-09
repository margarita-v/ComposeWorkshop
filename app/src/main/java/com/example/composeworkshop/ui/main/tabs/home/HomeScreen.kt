package com.example.composeworkshop.ui.main.tabs.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.composeworkshop.LoadState
import com.example.composeworkshop.domain.ProductsCategoryEntity

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onCategoryClick: (String) -> Unit,
    openNextScreen: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val loadState: LoadState by viewModel.loadState.collectAsState()
        val isRefreshing: Boolean by viewModel.isRefreshing.collectAsState()
        val alertMessage: Int? by viewModel.alertMessage.collectAsState()
        val categories: List<ProductsCategoryEntity> by viewModel.categories.collectAsState()

        Search()

        when (loadState) {
            LoadState.Loading -> MainLoading()
            LoadState.Error -> Error { viewModel.loadFeed() }
            LoadState.Succeed -> Success(
                categories,
                isRefreshing,
                alertMessage,
                onRefresh = { viewModel.refresh() },
                onCategoryClick = onCategoryClick,
                openNextScreen = openNextScreen
            )
        }
    }
}