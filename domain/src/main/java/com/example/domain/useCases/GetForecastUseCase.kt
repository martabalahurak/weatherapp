package com.example.domain.useCases

fun interface GetForecastUseCase {
    suspend fun invoke(city: String, days: Int): Forecast
}