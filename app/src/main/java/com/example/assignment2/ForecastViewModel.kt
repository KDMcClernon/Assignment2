package com.example.assignment2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ForecastViewModel @Inject constructor(private val api: OpenWeatherMapApi): ViewModel() {
    private val _forecast = Channel<Forecast>()

    public val forecast: Flow<Forecast> = _forecast.receiveAsFlow()

    fun fetchData() = runBlocking {
        val forecast = api.getForecast("55110")
        _forecast.trySend(forecast)
    }

    fun fetchForecast(latitudeLongitude: LatitudeLongitude) = runBlocking {
        val forecast = api.getForecast(latitudeLongitude.latitude, latitudeLongitude.longitude)
        _forecast.trySend(forecast)
    }

}