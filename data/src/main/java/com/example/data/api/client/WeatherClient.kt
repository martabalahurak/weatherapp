package com.example.data.api.client

import androidx.annotation.RequiresPermission
import com.example.domain.useCases.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherClient {

    @GET("/data/2.5/forecast/daily")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("cnt") days: Int,
        @Query("appId") appId: String,
        @Query("lang") lang: String,
        @Query("units") units: String
    ): Forecast
}