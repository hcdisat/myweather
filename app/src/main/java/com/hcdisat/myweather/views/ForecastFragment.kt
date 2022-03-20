package com.hcdisat.myweather.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hcdisat.myweather.adatpters.WeatherAdapter
import com.hcdisat.myweather.databinding.FragmentForecastBinding
import com.hcdisat.myweather.extensions.fahTemp
import com.hcdisat.myweather.extensions.maxFahTemp
import com.hcdisat.myweather.extensions.minFahTemp
import com.hcdisat.myweather.viewmodel.ResultStates

class ForecastFragment : BaseFragment() {

    private val binding by lazy {
        FragmentForecastBinding.inflate(layoutInflater)
    }

    private val weatherAdapter by lazy {
        WeatherAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        weatherViewModel.cityForecast.observe(viewLifecycleOwner, ::handleState)
        weatherViewModel.getForecast("Atlanta")

        binding.forecastList.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = weatherAdapter
        }

        return binding.root
    }

    private fun handleState(resultState: ResultStates?) {
        when (resultState) {
            is ResultStates.LOADING -> {
                Toast.makeText(
                    requireContext(),
                    "LOADING.....",
                    Toast.LENGTH_SHORT
                ).show()
            }
            is ResultStates.SUCCESS -> bind(resultState)

            is ResultStates.ERROR -> {
                Log.e("TAG", "handleState: ${resultState.error.localizedMessage}")
                Toast.makeText(
                    requireContext(),
                    resultState.error.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun bind(resultStates: ResultStates.SUCCESS) {
        binding.forecastDescription.text = resultStates
            .results.forecast[0].weather[0].description
        
        binding.forecastTemp.text = resultStates.results.forecast[0].main.fahTemp()
        binding.forecastCity.text = resultStates.results.city.name
        binding.forecastTempMax.text = resultStates.results.forecast[0].main.maxFahTemp()
        binding.forecastTempMin.text = resultStates.results.forecast[0].main.minFahTemp()

        weatherAdapter.setForecast(resultStates.results.forecast)

        binding.forecastLoading.visibility = View.GONE
        binding.forecastMainContainer.visibility = View.VISIBLE
        binding.forecastList.visibility = View.VISIBLE
    }
}