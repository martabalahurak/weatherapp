package com.example.weather.presentation.appConfig

import com.example.data.api.config.AppConfig
import com.example.weather.BuildConfig

class AppConfigImpl: AppConfig {
    override fun apiUrl(): String = BuildConfig.API_BASE_URL
    override fun appId(): String = BuildConfig.API_ID
}