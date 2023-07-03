package com.example.myapplication

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

// ViewModel для управления состоянием приложения
class MainViewModel : ViewModel() {
    private val dataUrl = "https://example.com/data" // Замените ссылку на фактическую

    var sum: Int = 0
        private set
    private val _users = mutableStateListOf<User>()
    val users: List<User> get() = _users

    // Функция для загрузки данных с сайта
    suspend fun fetchData(num1: Int, num2: Int) {
        sum = num1 + num2

        // Симуляция задержки загрузки данных
        delay(2000)

        // Загрузка данных с сайта
        val loadedData = loadDataFromUrl()

        // Обновление списка данных
        withContext(Dispatchers.Main) {
            _users.clear()
            _users.addAll(loadedData)
        }
    }

    // Функция для загрузки данных с указанного URL
    private fun loadDataFromUrl(): List<User> {
        // Вместо реальной загрузки данных, просто возвращаем тестовые данные
        return listOf(
            User("Алексей", "18"),
            User("Тимур", "20"),
            User("Дмитрий", "21")
        )
    }

}