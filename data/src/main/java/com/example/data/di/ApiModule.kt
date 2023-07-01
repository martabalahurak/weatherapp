package com.example.data.di

import com.example.data.api.apiImpl.ForecastApiImpl
import com.example.domain.api.ForecastApi
import org.koin.dsl.module

val apiModule = module {
    factory<ForecastApi> { ForecastApiImpl() }
}