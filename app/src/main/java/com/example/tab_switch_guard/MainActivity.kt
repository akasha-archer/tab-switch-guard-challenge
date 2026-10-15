package com.example.tab_switch_guard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.tab_switch_guard.presentation.ProductPagerWithTitles
import com.example.tab_switch_guard.presentation.ProductViewModel
import com.example.tab_switch_guard.ui.theme.TabswitchguardTheme

class MainActivity : ComponentActivity() {
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TabswitchguardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductPagerWithTitles(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}