package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class ForecastAdapter(private val data : List<DayForecast>) : RecyclerView.Adapter<ForecastViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_forecast_item, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val forecastTempHigh: TextView
    val forecastTempLow: TextView
    val forecastDate: TextView
    val forecastSunrise: TextView
    val forecastSunset: TextView

    init {
        forecastTempHigh = view.findViewById(R.id.forecast_temp_high)
        forecastTempLow = view.findViewById(R.id.forecast_temp_low)
        forecastDate = view.findViewById(R.id.forecast_date)
        forecastSunrise = view.findViewById(R.id.forecast_sunrise)
        forecastSunset = view.findViewById(R.id.forecast_sunset)
    }

    fun bind(data: DayForecast) {

        val dateTimeStamp = data.date
        val formatter = DateTimeFormatter.ofPattern("MMM dd")
        val dateTime = LocalDateTime.ofEpochSecond(dateTimeStamp, 0, ZoneOffset.of("-5"))
        val formattedDate = formatter.format(dateTime)

        val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")
        val formattedSunrise = timeFormatter.format(dateTime)

        val dateSunsetStamp = data.sunset
        val dateSunset = LocalDateTime.ofEpochSecond(dateSunsetStamp, 0, ZoneOffset.of("-5"))
        val formattedSunset = timeFormatter.format(dateSunset)

        forecastTempHigh.text = "High: " + data.temp.max + "°"
        forecastTempLow.text = "Low: " + data.temp.min + "°"
        forecastDate.text = formattedDate
        forecastSunrise.text = "Sunrise: $formattedSunrise"
        forecastSunset.text = "Sunset: $formattedSunset"
    }


}