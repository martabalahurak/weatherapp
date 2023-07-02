package com.example.data.api.di

import com.example.data.api.client.WeatherClient
import org.koin.dsl.module
import retrofit2.Retrofit

val apiClientModule = module {
    single<WeatherClient> {
        get<Retrofit>().create(
            WeatherClient::class.java
        )
    }
}