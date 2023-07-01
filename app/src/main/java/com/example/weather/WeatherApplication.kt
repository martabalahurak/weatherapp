package com.example.weather

import android.app.Application
import com.example.data.di.dataComponent
import com.example.domain.di.domainComponent
import com.example.weather.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class WeatherApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        setupDI()
    }

    private fun setupDI() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@WeatherApplication)
            modules(appComponent() + dataComponent() + domainComponent())
        }
    }

}