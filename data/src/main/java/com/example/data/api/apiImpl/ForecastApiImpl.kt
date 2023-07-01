package com.example.data.api.apiImpl

import com.example.domain.api.ForecastApi

class ForecastApiImpl : ForecastApi {
    override suspend fun getWeather(): String {
        return "Hey, here is the weather"
    }
}