package com.galib.animedroid

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

val client = HttpClient(CIO) {}
val json = Json { ignoreUnknownKeys = true }

suspend fun searchAnime(animeName: String): String {
    return try {
        val url = "https://api.jikan.moe/v4/anime"
        val response: String = client.get {
            url(url)
            parameter("q", animeName)
        }.body()
        val root = json.decodeFromString<Root>(response)
        "Total ${root.pagination.items.total} search results for \"$animeName\""
    } catch (e: Exception) {
        "Error searching for \"$animeName\": ${e.message}"
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
