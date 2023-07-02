package com.example.weather.di

import com.example.data.api.config.AppConfig
import com.example.weather.presentation.appConfig.AppConfigImpl
import org.koin.dsl.module


val appConfiguration = module {
    single<AppConfig> { AppConfigImpl() }
}