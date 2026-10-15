package com.example.tab_switch_guard.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tab_switch_guard.model.ProductCategory
import com.example.tab_switch_guard.model.ProductPagerTitles
import com.example.tab_switch_guard.model.allProducts
import com.example.tab_switch_guard.ui.theme.TabswitchguardTheme

@Composable
fun ProductPagerWithTitles(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel
) {
    val selectedTab by viewModel.selectedTab.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    ProductTabScreen(
        modifier = modifier,
        selectedTab = selectedTab,
        uiState = uiState,
        onTabSelected = viewModel::onTabSelected
    )
}

@Composable
fun ProductTabScreen(
    modifier: Modifier = Modifier,
    selectedTab: ProductPagerTitles,
    uiState: ProductUiState,
    onTabSelected: (ProductPagerTitles) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val selectedIndex = ProductPagerTitles.entries.indexOf(selectedTab)

        PrimaryTabRow(
            selectedTabIndex = selectedIndex,
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary,
            divider = {}
        ) {
            ProductPagerTitles.entries.forEachIndexed { index, tab ->
                val isSelected = index == selectedIndex
                Tab(
                    selected = isSelected,
                    onClick = { onTabSelected(tab) },
                    text = {
                        Text(
                            text = tab.title,
                            style = MaterialTheme.typography.titleMedium,
                            color = if (isSelected) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.onBackground
                            }
                        )
                    }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            when (uiState) {
                is ProductUiState.Loading -> {
                    LoadingStateScreen(tabTitle = uiState.tabTitle)
                }

                is ProductUiState.Success -> {
                    ProductList(
                        products = uiState.products,
                        productCategory = uiState.tab.category
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductPagerLoadingPreview() {
    TabswitchguardTheme {
        ProductTabScreen(
            selectedTab = ProductPagerTitles.ALL,
            uiState = ProductUiState.Loading("All"),
            onTabSelected = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductPagerSuccessPreview() {
    TabswitchguardTheme {
        ProductTabScreen(
            selectedTab = ProductPagerTitles.POPULAR,
            uiState = ProductUiState.Success(
                tab = ProductPagerTitles.POPULAR,
                products = allProducts.filter { it.productCategory.contains(ProductCategory.POPULAR) }
            ),
            onTabSelected = {}
        )
    }
}