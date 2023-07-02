package com.example.weather.di

import com.example.weather.presentation.screens.di.forecastModule
import org.koin.core.module.Module

fun appComponent(): List<Module> = listOf(
    appModule,
    appConfiguration,
    forecastModule
)
