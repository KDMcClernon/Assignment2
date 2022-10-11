package com.example.assignment2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.assignment2.databinding.FragmentCurrentConditionsBinding

class CurrentConditionsFragment : Fragment(R.layout.fragment_current_conditions) {

    private lateinit var binding: FragmentCurrentConditionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding =  FragmentCurrentConditionsBinding.bind(view)
        binding.forecastButton.setOnClickListener {
            val dayForecast = DayForecast(0, 0, 0, 0F, 0, ForecastTemp(0F, 0F))
            val action = CurrentConditionsFragmentDirections.actionCurrentConditionsFragmentToForecastFragment(dayForecast)
            findNavController().navigate(action)
        }
    }
}

