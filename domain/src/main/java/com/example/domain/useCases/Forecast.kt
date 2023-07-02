package com.example.domain.useCases

data class Forecast(
    val city: City,
    val cnt: Int,
    val list: List<DailyForecast>,
)

class DailyForecast(
    val sunrise: Long,
    val sunset: Long,
    val temp: Temperature,
    val feels_like: RelativeTemperature,
    val pressure: Long,
    val humidity: Int,
    val weather: List<WeatherDescription>,
    val speed: Float
)

data class WeatherDescription(
    val id: Long,
    val main: String,
    val description: String
)

data class RelativeTemperature(
    val day: String?,
    val night: String?,
    val eve: String?,
    val morn: String?
)

data class Temperature(
    val day: String?,
    val min: String?,
    val max: String?,
    val night: String?,
    val eve: String?,
    val morn: String?
)

data class City(
    val id: Long,
    val name: String,
    val country: String
)

