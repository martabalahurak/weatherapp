package com.example.data.api.apiImpl

import com.example.data.api.client.WeatherClient
import com.example.data.api.config.AppConfig
import com.example.domain.api.ForecastApi
import com.example.domain.useCases.Forecast

class ForecastApiImpl(private val client: WeatherClient, private val appConfig: AppConfig) :
    ForecastApi {
    override suspend fun getForecast(city: String, days: Int): Forecast {
        return client.getForecast(city, days, appConfig.appId(), LANGUAGE_EN, UNITS_CELSIUS)
    }

    private companion object{
        const val LANGUAGE_EN = "en"
        const val LANGUAGE_UA = "ua"
        const val UNITS_CELSIUS = "metric"
    }
}