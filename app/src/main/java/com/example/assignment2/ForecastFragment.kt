package com.example.assignment2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.assignment2.databinding.FragmentForecastBinding
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

val dayForecastData = listOf<DayForecast>(
    DayForecast(1664626200L, 1664626200L, 1664668320L, 30.34F, 60, ForecastTemp(72F, 52F)),
    DayForecast(1664712660L, 1664712660L, 1664754600L, 30.62F, 65, ForecastTemp(70F, 53F)),
    DayForecast(1664799120L, 1664799120L, 1664840880L, 30.55F, 64, ForecastTemp(74F, 57F)),
    DayForecast(1664885640L, 1664885640L, 1664927160L, 30.66F, 63, ForecastTemp(69F, 53F)),
    DayForecast(1664972040L, 1664972040L, 1665013440L, 30.44F, 72, ForecastTemp(68F, 39F)),
    DayForecast(1665058560L, 1665058560L, 1665099780L, 30.71F, 58, ForecastTemp(50F, 31F)),
    DayForecast(1665145020L, 1665145020L, 1665186060L, 30.45F, 55, ForecastTemp(50F, 36F)),
    DayForecast(1665231480L, 1665231480L, 1665272340L, 30.55F, 54, ForecastTemp(54F, 37F)),
    DayForecast(1665318000L, 1665318000L, 1665358620L, 30.67F, 61, ForecastTemp(58F, 41F)),
    DayForecast(1665404460L, 1665404460L, 1665444900L, 30.41F, 61, ForecastTemp(60F, 42F)),
    DayForecast(1665490920L, 1665490920L, 1665531240L, 30.72F, 60, ForecastTemp(62F, 42F)),
    DayForecast(1665577380L, 1665577380L, 1665617520L, 30.97F, 59, ForecastTemp(61F, 43F)),
    DayForecast(1665663900L, 1665663900L, 1665703800L, 30.60F, 57, ForecastTemp(62F, 42F)),
    DayForecast(1665750360L, 1665750360L, 1665790080L, 30.53F, 57, ForecastTemp(61F, 44F)),
    DayForecast(1665836820L, 1665836820L, 1665876360L, 30.45F, 57, ForecastTemp(60F, 45F)),
    DayForecast(1665923280L, 1665923280L, 1665962640L, 30.77F, 55, ForecastTemp(58F, 40F)),
)



class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private lateinit var binding: FragmentForecastBinding
    private val args: ForecastFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(dayForecastData)

        val dateTimeStamp = 1664393673L
        val formatter = DateTimeFormatter.ofPattern("MMM dd")
        val dateTime = LocalDateTime.ofEpochSecond(dateTimeStamp, 0, ZoneOffset.of("-5"))
        val formattedDate = formatter.format(dateTime)

        val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")
        val formattedTime = timeFormatter.format(dateTime)

        Log.d("ForecastFragment", formattedDate)
        Log.d("ForecastFragment", formattedTime)
    }
}