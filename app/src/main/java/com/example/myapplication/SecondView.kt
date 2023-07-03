package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SecondView(viewModel: MainViewModel, onBackClicked: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(
            onClick = { onBackClicked() },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Назад")
        }
        Text(
            text = "Сумма чисел: ${viewModel.sum}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        if (viewModel.users.isNotEmpty()) {
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Имя:",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    for (user in viewModel.users) {
                        Text(
                            text = user.name,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Возраст:",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    for (user in viewModel.users) {
                        Text(
                            text = user.age,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        } else {
            Text(
                text = "Данные не загружены",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}


