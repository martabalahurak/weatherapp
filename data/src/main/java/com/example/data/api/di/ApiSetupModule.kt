package com.example.data.api.di

import com.example.data.api.di.factory.GsonFactory
import com.example.data.api.interceptors.HeaderInterceptor
import org.koin.dsl.module

val apiSetupModule = module {
    single { GsonFactory.buildGson() }
    single { HeaderInterceptor() }
}

const val CONNECT_TIMEOUT = 20L
const val READ_WRITE_TIMEOUT = 30L