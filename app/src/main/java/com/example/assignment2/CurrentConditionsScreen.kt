@file:JvmName("CurrentConditionsKt")

package com.example.assignment2

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditionsScreen(
    viewModel: CurrentConditionsViewModel = hiltViewModel(),
    onForecastButtonClick: () -> Unit,
) {
    val state by viewModel.currentConditions.collectAsState(initial = null)

    LaunchedEffect(Unit){
        viewModel.fetchData()
    }
    
    Scaffold(
        topBar = { TopAppBar(title = { stringResource(id = R.string.app_name) })} ,
    ) {
        state?.let {
            CurrentConditionsContent(currentConditions = it) {
                onForecastButtonClick()
            }
        }
    }

}

@Composable
private fun CurrentConditionsContent(
    currentConditions: CurrentConditions,
    onForecastButtonClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = stringResource(id = R.string.city_name),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400)
            )
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = R.string.temperature, currentConditions.conditions.temperature.toInt()),
                style = TextStyle(
                    fontSize = 72.sp,
                    fontWeight = FontWeight(700),
                )
            )
            Spacer(modifier = Modifier.weight(1.0f, fill = true))

            val iconUrl = String.format("https://openweathermap.org/img/wn/%s@2x.png", currentConditions.weatherData.firstOrNull()?.iconName)

            AsyncImage(
                model = iconUrl,
                modifier = Modifier.size(72.dp),
                contentDescription = "Sunny",
            )
        }

        Text(
            text = stringResource(id = R.string.low_temp, currentConditions.conditions.minTemperature.toInt()),
        )

        Text(
            text = stringResource(id = R.string.high_temp, currentConditions.conditions.maxTemperature.toInt()),
        )

        Text(
            text = stringResource(id = R.string.humidity, currentConditions.conditions.humidity.toInt()),
        )

        Text(
            text = stringResource(id = R.string.pressure, currentConditions.conditions.pressure.toInt()),
        )

        Button(onClick = onForecastButtonClick) {
            Text(text = stringResource(id = R.string.forecast))
        }

    }
}


@Preview(
    "CurrentConditions",
    device = Devices.PIXEL_4,
    showBackground = true,
) @Composable
fun CurrentConditionsScreenPreview() {
    CurrentConditionsScreen{}
}