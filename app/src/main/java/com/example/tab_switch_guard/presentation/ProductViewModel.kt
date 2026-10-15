package com.example.tab_switch_guard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tab_switch_guard.model.ProductData
import com.example.tab_switch_guard.model.ProductPagerTitles
import com.example.tab_switch_guard.model.allProducts
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface ProductUiState {
    data class Loading(val tabTitle: String) : ProductUiState
    data class Success(val tab: ProductPagerTitles, val products: List<ProductData>) : ProductUiState
}

class ProductViewModel : ViewModel() {
    private var loadJob: Job? = null

    private val _selectedTab = MutableStateFlow(ProductPagerTitles.ALL)
    val selectedTab: StateFlow<ProductPagerTitles> = _selectedTab.asStateFlow()

    private val _uiState = MutableStateFlow<ProductUiState>(
        ProductUiState.Loading(ProductPagerTitles.ALL.title)
    )
    val uiState: StateFlow<ProductUiState> = _uiState.asStateFlow()

    init {
        loadDataForTab(ProductPagerTitles.ALL)
    }

    fun onTabSelected(tab: ProductPagerTitles) {
        if (_selectedTab.value == tab && _uiState.value is ProductUiState.Success) {
            return
        }
        _selectedTab.value = tab
        loadDataForTab(tab)
    }

    private fun loadDataForTab(tab: ProductPagerTitles) {
        // 1. Cancel previous in-flight job immediately
        loadJob?.cancel()

        // 2. Immediately transition to Loading state (previous content hidden)
        _uiState.value = ProductUiState.Loading(tab.title)

        // 3. Launch new coroutine with simulated latency
        loadJob = viewModelScope.launch {
            delay(tab.delayMs)
            val filtered = allProducts.filter { it.productCategory.contains(tab.category) }
            _uiState.value = ProductUiState.Success(tab = tab, products = filtered)
        }
    }
}
