package com.example.assignment2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastTemp(
    val max: Float,
    val min: Float,
) : Parcelable
