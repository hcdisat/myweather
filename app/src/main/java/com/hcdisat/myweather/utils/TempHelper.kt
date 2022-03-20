package com.hcdisat.myweather.utils

object TempHelper {

    fun kelToFah(kelvinTem: Double): Int =
        (1.8 * (kelvinTem - 273.15) + 32).toInt()

    fun formatFah(fahTemp: Int): String = "$fahTemp°F"

    fun getFahFromKel(kelvinTem: Double): String =
        formatFah(kelToFah(kelvinTem))
}