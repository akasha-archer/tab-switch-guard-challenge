package com.example.tab_switch_guard.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tab_switch_guard.model.ProductCategory
import com.example.tab_switch_guard.model.ProductData
import com.example.tab_switch_guard.model.allProducts
import com.example.tab_switch_guard.ui.theme.Background
import com.example.tab_switch_guard.ui.theme.Surface

@Composable
fun ProductList(
    modifier: Modifier = Modifier,
    products: List<ProductData> = listOf(),
    productCategory: ProductCategory = ProductCategory.ALL
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Background)
    ) {
        val productsToDisplay = products.filter { product ->
            product.productCategory.contains(productCategory)
        }
        ProductResultCount(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp),
            count = productsToDisplay.size
        )
        productsToDisplay.forEach { product ->
            ItemCard(
                imageResource = product.imageThumbnail,
                productData = product
            )
        }
    }
}

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    imageResource: Int,
    productData: ProductData
) {
    Card(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = "Thumbnail image of ${productData.productName}",
                modifier = Modifier
                    .weight(1f)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            ProductDetails(
                modifier = Modifier.weight(2f),
                productData = productData
            )
        }
    }
}

@Composable
fun ProductDetails(
    modifier: Modifier = Modifier,
    productData: ProductData
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 12.dp)
    ) {
        Text(
            modifier = Modifier,
            text = productData.productName,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            modifier = Modifier,
            text = productData.getSubtitleList(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = productData.productPrice,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun ProductResultCount(
    modifier: Modifier = Modifier,
    count: Int
) {
    Text(
        modifier = modifier,
        text = "$count results",
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ProductList(
        modifier = Modifier,
        products = allProducts
    )
}