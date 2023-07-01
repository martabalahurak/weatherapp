package com.example.domain.useCases.di

import com.example.domain.useCases.GetForecastUseCase
import com.example.domain.useCases.impl.GetForecastUseCaseImpl
import org.koin.dsl.module

val forecastUseCaseModule = module {
    factory<GetForecastUseCase> { GetForecastUseCaseImpl(get()) }
}