package com.example.domain.useCases.impl

import com.example.domain.api.ForecastApi
import com.example.domain.useCases.Forecast
import com.example.domain.useCases.GetForecastUseCase

class GetForecastUseCaseImpl(private val forecastApi: ForecastApi): GetForecastUseCase {
    override suspend fun invoke(city: String, days: Int): Forecast {
        return forecastApi.getForecast(city, days)
    }
}