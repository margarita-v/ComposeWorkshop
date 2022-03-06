package com.example.composeworkshop.ui.main.tabs.home

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.composeworkshop.domain.ProductsCategoryEntity
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@ExperimentalCoilApi
@Composable
fun Success(
    categories: List<ProductsCategoryEntity>,
    isRefreshing: Boolean,
    @StringRes alertMessageResId: Int?,
    onRefresh: () -> Unit,
    onCategoryClick: (String) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }

    if (alertMessageResId != null) {
        val alertMessage = stringResource(id = alertMessageResId)
        LaunchedEffect(alertMessageResId) {
            snackbarHostState.showSnackbar(alertMessage)
        }
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = { onRefresh() },
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = trigger,
                scale = true,
                contentColor = MaterialTheme.colors.primary,
            )
        }
    ) {
        CategoriesList(categories = categories, onCategoryClick = onCategoryClick)

        SnackbarHost(
            modifier = Modifier.fillMaxWidth(),
            hostState = snackbarHostState
        )
    }
}

@ExperimentalCoilApi
@Composable
private fun CategoriesList(
    categories: List<ProductsCategoryEntity>,
    onCategoryClick: (String) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            LazyRow {
                categories.forEachIndexed { index, category ->
                    item {
                        Category(
                            category,
                            modifier = when (index) {
                                0 -> Modifier.padding(start = 20.dp)
                                categories.lastIndex -> Modifier.padding(
                                    start = 12.dp,
                                    end = 20.dp
                                )
                                else -> Modifier.padding(start = 12.dp)
                            },
                            onCategoryClick = onCategoryClick
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
private fun Category(
    category: ProductsCategoryEntity,
    modifier: Modifier = Modifier,
    onCategoryClick: (String) -> Unit
) {
    val painter = rememberImagePainter(data = category.icon)

    Column(
        modifier = modifier.padding(top = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(20.dp))
                .clickable {
                    onCategoryClick(category.name)
                },
            painter = painter,
            contentDescription = category.name,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(12.dp),
            textAlign = TextAlign.Center,
            text = category.shortName,
            style = MaterialTheme.typography.caption
        )
    }
}