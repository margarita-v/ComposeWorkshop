package com.example.composeworkshop.ui.main.tabs.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.composeworkshop.domain.ProductsCategoryEntity

@ExperimentalCoilApi
@Composable
fun Success(categories: List<ProductsCategoryEntity>) {
    LazyRow {
        categories.forEachIndexed { index, category ->
            item {
                Category(
                    category,
                    modifier = when (index) {
                        0 -> Modifier.padding(start = 20.dp)
                        categories.lastIndex -> Modifier.padding(start = 12.dp, end = 20.dp)
                        else -> Modifier.padding(start = 12.dp)
                    }
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun Category(category: ProductsCategoryEntity, modifier: Modifier = Modifier) {
    val painter = rememberImagePainter(data = category.icon)

    Image(
        modifier = modifier
            .size(64.dp)
            .clickable {
                // todo handle category click
            },
        painter = painter,
        contentDescription = category.name,
        contentScale = ContentScale.Crop
    )
}