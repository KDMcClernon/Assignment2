package com.example.assignment2

import com.squareup.moshi.Json

data class TempData(
    @Json(name = "temp_min") val minTemperature: Float,
    @Json(name = "temp_max") val maxTemperature: Float,
)

data class ForecastData(
    @Json(name = "temp") val tempData: TempData,
    @Json(name = "sunrise") val sunrise: Float,
    @Json(name = "sunset") val sunset: Float,
    @Json(name = "pressure") val pressure: Float,
    @Json(name = "humidity") val humidity: Float,
    @Json(name = "dt") val date: Long
)

data class Forecast(
    @Json(name = "list") val forecastData: List<ForecastData>
)