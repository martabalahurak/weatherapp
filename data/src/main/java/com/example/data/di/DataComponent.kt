package com.example.data.di

import com.example.data.api.di.apiClientModule
import com.example.data.api.di.apiModule
import com.example.data.api.di.apiSetupModule
import com.example.data.api.di.retrofitModule
import org.koin.core.module.Module

fun dataComponent(): List<Module> = listOf(
    apiModule,
    apiClientModule,
    apiSetupModule,
    retrofitModule
)
