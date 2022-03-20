package com.hcdisat.myweather

import android.app.Application
import com.hcdisat.myweather.di.networkModule
import com.hcdisat.myweather.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherApp)
            modules(
                listOf(networkModule, viewModelModule)
            )
        }
    }
}