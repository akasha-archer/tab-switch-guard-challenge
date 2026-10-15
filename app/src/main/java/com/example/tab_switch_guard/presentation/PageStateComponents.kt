package com.example.tab_switch_guard.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingStateScreen(
    modifier: Modifier = Modifier,
    tabTitle: String = "All"
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            64.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(72.dp),
        )
        Text(
            text = "Loading \"$tabTitle\"...",
        )
    }
}


@Preview
@Composable
fun LoadingStateScreenPreview() {
    LoadingStateScreen()
}