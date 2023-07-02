package com.example.domain.api

import com.example.domain.useCases.Forecast

interface ForecastApi {

    suspend fun getForecast(city: String, days: Int): Forecast
}