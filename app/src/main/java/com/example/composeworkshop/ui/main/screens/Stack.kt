package com.example.composeworkshop.ui.main.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Stack(title: String, openScreenClick: () -> Unit, clearStackClick: () -> Unit) {
    Column {
        Text(text = title, modifier = Modifier.padding(top = 30.dp, start = 16.dp))
        Button(onClick = { openScreenClick() }) {
            Text(text = "Open next screen")
        }
        Button(onClick = { clearStackClick() }) {
            Text(text = "Clear stack")
        }
    }
}