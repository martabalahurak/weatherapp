package com.example.weather.di

import com.example.weather.presentation.common.CoroutineDispatchers
import com.example.weather.presentation.common.CoroutineDispatchersImpl
import org.koin.dsl.module

val appModule = module {
    single<CoroutineDispatchers> { CoroutineDispatchersImpl() }
}