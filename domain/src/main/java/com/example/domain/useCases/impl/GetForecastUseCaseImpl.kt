package com.example.domain.useCases.impl

import com.example.domain.api.ForecastApi
import com.example.domain.useCases.GetForecastUseCase

class GetForecastUseCaseImpl(private val forecastApi: ForecastApi): GetForecastUseCase {
    override suspend fun invoke(): String {
        return forecastApi.getWeather()
    }
}