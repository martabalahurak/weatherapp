package com.example.data.api.di

import com.example.data.api.apiImpl.ForecastApiImpl
import com.example.domain.api.ForecastApi
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

val apiModule = module {
    factory<ForecastApi> { ForecastApiImpl() }
    single { HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY } }
}