package com.example.tab_switch_guard.presentation

import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProductPagerWithTitles(
    modifier: Modifier = Modifier,
) {

}

@Composable
fun BaseProductPager(
    modifier: Modifier = Modifier,
    pages: List<String> = listOf(),
    pagerState: PagerState
) {

}

@Preview
@Composable
fun ProductPagerPreview() {
    ProductPagerWithTitles()
}