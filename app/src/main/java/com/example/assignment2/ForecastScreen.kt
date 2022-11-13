package com.example.assignment2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.intellij.lang.annotations.JdkConstants

val startDay = 1665014348L
val sunrise = 1664953200L
val sunset = 1664996400L

val forecastData = (0 until 16).map {
    DayForecast (
        date = startDay + (it * (24 * 60 * 60)),
        sunrise = sunrise + (it * (24 * 60 * 60)),
        sunset = sunset + (it * (24 * 60 * 60)),
        temp = ForecastTemp(min = 70f + it, max = 80f + it),
        pressure = 1024f,
        humidity = 76,
    )
}

@Composable
fun ForecastScreen(
    viewModel: ForecastViewModel = hiltViewModel(),
) {
    val state by viewModel.forecast.collectAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    state?.let {
        LazyColumn {
            items(items = forecastData) { item: DayForecast ->
                ForecastRow(item = item, forecast = it)
          }
        }
    }
}

@Composable
private fun ForecastRow(item: DayForecast, forecast: Forecast) {
    Row(
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        val textStyle = TextStyle(
            fontSize = 12.sp
        )
        Image(painter = painterResource(id = R.drawable.sun_icon), contentDescription = "")
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Text(
            text = forecast.forecastData[1].date.toString(),
            style = TextStyle(
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column {
            Text(
                text = stringResource(id = R.string.forecast_high_temp, forecast.forecastData[1].tempData.maxTemperature.toInt()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.forecast_low_temp, forecast.forecastData[1].tempData.minTemperature.toInt()),
                style = textStyle,
            )
        }
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = stringResource(id = R.string.sunrise, forecast.forecastData[1].sunrise),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.sunset, forecast.forecastData[1].sunset),
                style = textStyle,
            )
        }
    }

}

@Preview(
    showSystemUi = true
)
@Composable
private fun ForecastRowPreview() {
    //ForecastRow(item = forecastData[0])
}