package com.hcdisat.myweather.extensions

import com.hcdisat.myweather.models.Forecast
import com.hcdisat.myweather.models.Main
import com.hcdisat.myweather.utils.TempHelper
import java.text.SimpleDateFormat
import java.util.*

fun Forecast.forDate(pattern: String = "HH:mm"): String {
    val formatter = SimpleDateFormat(pattern)
    val date = Date(this.dt.toLong() * 1000)
    return formatter.format(date)
}

fun Main.fahTemp(): String =
    TempHelper.formatFah(TempHelper.kelToFah(this.temp))

fun Main.minFahTemp(): String =
    TempHelper.formatFah(TempHelper.kelToFah(this.tempMin))

fun Main.maxFahTemp(): String =
    TempHelper.formatFah(TempHelper.kelToFah(this.tempMax))