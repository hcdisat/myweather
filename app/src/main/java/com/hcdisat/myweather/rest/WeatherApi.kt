package com.hcdisat.myweather.rest

import com.hcdisat.myweather.models.Forecast
import com.hcdisat.myweather.models.WeatherForecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(FORECAST_PATH)
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appId") appId: String = API_KEY
    ): Response<WeatherForecast>

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
        private const val FORECAST_PATH = "data/2.5/forecast"

        private const val API_KEY = "65d00499677e59496ca2f318eb68c049"
    }
}