package com.example.weather.presentation.screens.di

import com.example.weather.presentation.screens.ForecastViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val forecastModule = module {
    viewModel{ForecastViewModel(get(), get())}
}