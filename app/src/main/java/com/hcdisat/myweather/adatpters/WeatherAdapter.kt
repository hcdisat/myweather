package com.hcdisat.myweather.adatpters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hcdisat.myweather.databinding.ForecastItemBinding
import com.hcdisat.myweather.extensions.fahTemp
import com.hcdisat.myweather.extensions.forDate
import com.hcdisat.myweather.models.Forecast

class WeatherAdapter(
    private val forecast: MutableList<Forecast> = mutableListOf()
): RecyclerView.Adapter<ForecastViewHolder>() {

    fun setForecast(newForecast: List<Forecast>) {
        forecast.clear()
        forecast.addAll(newForecast)
        notifyItemRangeChanged(0, itemCount)
//        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = ForecastItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(forecast[position])
    }

    override fun getItemCount(): Int = forecast.size
}


private const val ICON_URL = "https://openweathermap.org/img/w/"
class ForecastViewHolder(
    private val binding: ForecastItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

    fun bind(forecast: Forecast) {
        binding.forecastTime.text = forecast.forDate()
        binding.weatherTemp.text = forecast.main.fahTemp()
        binding.weatherDescription.text = forecast.weather[0].description
    }
}