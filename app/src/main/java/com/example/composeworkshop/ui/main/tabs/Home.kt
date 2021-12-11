package com.example.composeworkshop.ui.main.tabs

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeworkshop.ui.theme.Gray050
import com.example.composeworkshop.R
import com.example.composeworkshop.ui.theme.SteelGray300

@Composable
fun HomeScreen() {
    // loading
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(36.dp),
            shape = MaterialTheme.shapes.medium,
            backgroundColor = Gray050
        ) {
            Search()
        }
    }
}

@Composable
private fun Search() {
    Row(
        modifier = Modifier
            .padding(start = 14.dp, end = 14.dp)
            .clickable {
                //todo open search
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(12.dp),
            painter = painterResource(id = R.drawable.ic_search),
            tint = SteelGray300,
            contentDescription = "search"
        )

        Text(
            modifier = Modifier
                .padding(start = 14.dp, end = 14.dp)
                .weight(1f),
            text = stringResource(id = R.string.search_title),
            color = SteelGray300
        )

        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.ic_microphone),
            tint = SteelGray300,
            contentDescription = "voice_search"
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}