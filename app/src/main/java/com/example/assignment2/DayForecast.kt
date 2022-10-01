package com.example.assignment2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayForecast(
    val date: Long,
    val sunrise: Long,
    val sunset: Long,
    val pressure: Float,
    val humidity: Int,
    val temp: ForecastTemp
) : Parcelable
