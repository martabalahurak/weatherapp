package com.example.data.api.di

import com.example.data.api.config.AppConfig
import com.example.data.api.di.factory.WeatherRetrofitFactory
import org.koin.dsl.module

val retrofitModule = module {
    single {
        WeatherRetrofitFactory(
            get(),
            get(),
            get()
        ).build(get<AppConfig>().apiUrl())
    }
}