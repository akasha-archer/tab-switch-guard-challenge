package com.example.tab_switch_guard.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tab_switch_guard.ui.theme.Background
import com.example.tab_switch_guard.ui.theme.OnSurfaceVariant
import com.example.tab_switch_guard.ui.theme.Outline
import com.example.tab_switch_guard.ui.theme.Primary

@Composable
fun LoadingStateScreen(
    modifier: Modifier = Modifier,
    tabTitle: String = "All"
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            16.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(48.dp),
            color = Primary,
            trackColor = Outline
        )
        Text(
            text = "Loading \"$tabTitle\"...",
            style = MaterialTheme.typography.bodyMedium,
            color = OnSurfaceVariant
        )
    }
}


@Preview
@Composable
fun LoadingStateScreenPreview() {
    LoadingStateScreen()
}