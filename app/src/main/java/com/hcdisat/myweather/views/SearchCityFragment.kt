package com.hcdisat.myweather.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hcdisat.myweather.databinding.FragmentSearchCityBinding
import com.squareup.picasso.Picasso

class SearchCityFragment : Fragment() {

    private val binding by lazy {
        FragmentSearchCityBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Picasso.get()
            .load("http://openweathermap.org/img/wn/10d@6x.png")
            .into(binding.testIcon)

        return binding.root
    }
}