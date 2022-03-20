package com.hcdisat.myweather.viewmodel

import com.hcdisat.myweather.models.WeatherForecast

sealed class ResultStates {
    object LOADING: ResultStates()
    class SUCCESS(val results: WeatherForecast): ResultStates()
    class ERROR(val error: Throwable): ResultStates()
}
