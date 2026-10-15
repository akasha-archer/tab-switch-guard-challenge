package com.example.tab_switch_guard.model

enum class ProductPagerTitles(value: String) {
    ALL("All"),
    POPULAR("Popular"),
    NEW("New"),
    SALE("Sale");
}

val tabs = listOf(
    ProductPagerTitles.ALL.name,
    ProductPagerTitles.POPULAR.name,
    ProductPagerTitles.NEW.name,
    ProductPagerTitles.SALE.name
)
