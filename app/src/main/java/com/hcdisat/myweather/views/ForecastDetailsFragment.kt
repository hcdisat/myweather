package com.hcdisat.myweather.views

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hcdisat.myweather.R
import com.hcdisat.myweather.databinding.FragmentForecastDetailsBinding
import com.hcdisat.myweather.extensions.fahTemp
import com.hcdisat.myweather.extensions.forDate
import com.hcdisat.myweather.extensions.maxFahTemp
import com.hcdisat.myweather.extensions.minFahTemp
import com.hcdisat.myweather.models.Forecast

class ForecastDetailsFragment : Fragment() {

    private val binding by lazy {
        FragmentForecastDetailsBinding.inflate(layoutInflater)
    }

    private var forecast: Forecast? = null
    private var cityName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            forecast = it?.getParcelable(FORECAST_KEY)
            cityName = it?.getString(CITY_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bind()

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun bind() {
        forecast?.let {
            binding.city.text = "@$cityName"
            binding.date.text = it.forDate("MM/dd H:m:s")
            binding.description.text = it.weather[0].description
            binding.temp.text = it.main.fahTemp()
            binding.tempMax.text = "H:${it.main.maxFahTemp()}"
            binding.tempMin.text = "L:${it.main.minFahTemp()}"
        }
    }
}