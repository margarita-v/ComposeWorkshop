package com.example.composeworkshop.ui.main.tabs.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeworkshop.ui.main.core.LoadStub

//todo fix shimmer colors for themes

@Composable
fun MainLoading() {
    // banners
    LoadStub(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .fillMaxWidth()
            .height(168.dp),
        shapeSize = 20.dp
    ) {
        Column {
            Spacer(modifier = Modifier.weight(1f))
            LoadStub(
                modifier = Modifier
                    .padding(start = 32.dp, bottom = 12.dp)
                    .width(190.dp)
                    .height(8.dp),
                color = Color.White
            )
            LoadStub(
                modifier = Modifier
                    .padding(start = 32.dp, bottom = 32.dp)
                    .width(130.dp)
                    .height(8.dp),
                color = Color.White
            )
        }
    }

    // categories
    Row(
        modifier = Modifier
            .padding(start = 20.dp, top = 40.dp, bottom = 40.dp)
    ) {
        repeat(4) {
            LoadStub(
                modifier = Modifier
                    .padding(start = if (it > 0) 12.dp else 0.dp)
                    .size(64.dp),
                shapeSize = 20.dp
            )
        }
    }

    // delivery
    LoadStub(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp)
            .fillMaxWidth()
            .height(96.dp),
        shapeSize = 20.dp
    ) {
        Column {
            LoadStub(
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .width(182.dp)
                    .height(8.dp),
                color = Color.White
            )
            LoadStub(
                modifier = Modifier
                    .padding(start = 16.dp, top = 10.dp)
                    .width(124.dp)
                    .height(8.dp),
                color = Color.White
            )
        }
    }
}