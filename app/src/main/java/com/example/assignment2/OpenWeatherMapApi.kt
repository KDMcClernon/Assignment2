package com.example.assignment2

import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "d7c5882815c7eb39fbf10f7229b2efc6",
        @Query("units") units: String = "imperial",
    ) : CurrentConditions

    @GET("data/2.5/forecast")
    suspend fun getForecast(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "d7c5882815c7eb39fbf10f7229b2efc6",
        @Query("units") units: String = "imperial",
    ) : Forecast

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("lat") latitude: Float,
        @Query("long") longitude: Float,
        @Query("appid") apiKey: String = "d7c5882815c7eb39fbf10f7229b2efc6",
        @Query("units") units: String = "imperial",
    ) : CurrentConditions

    @GET("data/2.5/forecast")
    suspend fun getForecast(
        @Query("lat") latitude: Float,
        @Query("long") longitude: Float,
        @Query("appid") apiKey: String = "d7c5882815c7eb39fbf10f7229b2efc6",
        @Query("units") units: String = "imperial",
    ) : Forecast

}