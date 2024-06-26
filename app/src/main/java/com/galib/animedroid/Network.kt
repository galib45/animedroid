package com.galib.animedroid

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*

val client = HttpClient(CIO) {
    install(Logging) {
        level = LogLevel.INFO
    }
}

// suspend fun getAnime(anime: String): String {
//     return try {
//         val response: String = client.get("https://api.openweathermap.org/data/2.5/weather") {
//             parameter("q", city)
//             parameter("appid", "YOUR_API_KEY")
//             parameter("units", "metric")
//         }.body()
//
//         val weatherResponse = Gson().fromJson(response, WeatherResponse::class.java)
//         "Temperature in $city: ${weatherResponse.main.temp}°C"
//     } catch (e: Exception) {
//         "Error fetching weather data: ${e.message}"
//     }
// }
