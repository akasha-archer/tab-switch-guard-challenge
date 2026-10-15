package com.example.tab_switch_guard.model

import com.example.tab_switch_guard.ALL_DELAY
import com.example.tab_switch_guard.NEW_DELAY
import com.example.tab_switch_guard.POPULAR_DELAY
import com.example.tab_switch_guard.SALE_DELAY

enum class ProductPagerTitles(
    val title: String,
    val delayMs: Long,
    val category: ProductCategory
) {
    ALL("All", ALL_DELAY, ProductCategory.ALL),
    POPULAR("Popular", POPULAR_DELAY, ProductCategory.POPULAR),
    NEW("New", NEW_DELAY, ProductCategory.NEW),
    SALE("Sale", SALE_DELAY, ProductCategory.SALE);
}

val tabs = ProductPagerTitles.entries.map { it.title }

