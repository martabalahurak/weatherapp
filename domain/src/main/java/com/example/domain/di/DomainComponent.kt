package com.example.domain.di

import com.example.domain.useCases.di.forecastUseCaseModule
import org.koin.core.module.Module

fun domainComponent(): List<Module> = listOf(
    forecastUseCaseModule
)
