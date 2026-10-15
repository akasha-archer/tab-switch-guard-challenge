package com.example.tab_switch_guard.model

import androidx.annotation.DrawableRes
import com.example.tab_switch_guard.R

data class ProductData(
    @DrawableRes val imageThumbnail: Int,
    val productName: String,
    val productPrice: String,
    val subTitle: List<String>,
    val productCategory: List<ProductCategory>
) {
    fun getSubtitleList(): String {
        return subTitle.joinToString(separator = "  •  ")
    }
}

enum class ProductCategory {
    ALL,
    POPULAR,
    NEW,
    SALE
}

val allProducts = listOf(
    ProductData(
        imageThumbnail = R.drawable.wireless_earbods,
        productName = "Wireless Earbuds Pro",
        productPrice = "$49.99",
        subTitle = listOf("Noise-Cancelling", "BT 5.3"),
        productCategory = listOf(ProductCategory.ALL, ProductCategory.POPULAR)
    ),

    ProductData(
        imageThumbnail = R.drawable.laptop_stand,
        productName = "Ergonomic Laptop Stand",
        productPrice = "$34.99",
        subTitle = listOf("Aluminum", "Adjustable"),
        productCategory = listOf(ProductCategory.ALL, ProductCategory.SALE)
    ),

    ProductData(
        imageThumbnail = R.drawable.usbc_hub,
        productName = "USB-C Hub 7-in-1",
        productPrice = "$29.99",
        subTitle = listOf("4K", "HDMI", "100W PD"),
        productCategory = listOf(ProductCategory.ALL, ProductCategory.SALE)
    ),

    ProductData(
        imageThumbnail = R.drawable.mechanical_keyboard,
        productName = "Mechanical Keyboard TKL",
        productPrice = "$89.99",
        subTitle = listOf("RGB", "Hot-swap switches"),
        productCategory = listOf(ProductCategory.ALL, ProductCategory.NEW)
    ),

    ProductData(
        imageThumbnail = R.drawable.portable_charger,
        productName = "Portable Charger 20K",
        productPrice = "$39.99",
        subTitle = listOf("USB-C", "Fast charge 65W"),
        productCategory = listOf(ProductCategory.ALL, ProductCategory.NEW)
    ),

    ProductData(
        imageThumbnail = R.drawable.webcam,
        productName = "Webcam HD 1080p",
        productPrice = "$54.99",
        subTitle = listOf("Auto-focus", "Ring light"),
        productCategory = listOf(ProductCategory.ALL, ProductCategory.NEW)
    ),

    ProductData(
        imageThumbnail = R.drawable.led_lamp,
        productName = "LED Desk Lamp",
        productPrice = "$49.99",
        subTitle = listOf("Dimmable", "USB-A port"),
        productCategory = listOf(ProductCategory.ALL, ProductCategory.SALE)
    ),
)