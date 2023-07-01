package com.example.domain.api

interface ForecastApi {

    suspend fun getWeather(): String
}