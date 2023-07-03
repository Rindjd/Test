package com.example.myapplication

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MyApp(viewModel: MainViewModel) {
    Surface(color = MaterialTheme.colorScheme.background) {
        var currentView by remember { mutableStateOf(1) }

        when (currentView) {
            1 -> FirstView(
                viewModel = viewModel,
                onNextClicked = { currentView = 2 }
            )
            2 -> SecondView(
                viewModel = viewModel,
                onBackClicked = { currentView = 1 }
            )
        }
    }
}