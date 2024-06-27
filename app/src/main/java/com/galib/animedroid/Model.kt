package com.galib.animedroid

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Root(
    val pagination: Pagination,
    val data: List<Datum>,
)

@Serializable
data class Pagination(
    @SerialName("last_visible_page")
    val lastVisiblePage: Long,
    @SerialName("has_next_page")
    val hasNextPage: Boolean,
    @SerialName("current_page")
    val currentPage: Long,
    val items: Items,
)

@Serializable
data class Items(
    val count: Long,
    val total: Long,
    @SerialName("per_page")
    val perPage: Long,
)

@Serializable
data class Datum(
    val title: String,
    @SerialName("title_english")
    val titleEnglish: String?,
    val episodes: Long?,
    val status: String,
    val duration: String,
    val score: Double?,
    val year: Long?,
)

// @Serializable
// data class Datum(
//     @SerialName("mal_id")
//     val malId: Long,
//     val url: String,
//     val images: Images,
//     val trailer: Trailer,
//     val approved: Boolean,
//     val titles: List<Title>,
//     val title: String,
//     @SerialName("title_english")
//     val titleEnglish: String?,
//     @SerialName("title_japanese")
//     val titleJapanese: String,
//     @SerialName("title_synonyms")
//     val titleSynonyms: List<String>,
//     val type: String,
//     val source: String,
//     val episodes: Long,
//     val status: String,
//     val airing: Boolean,
//     val aired: Aired,
//     val duration: String,
//     val rating: String,
//     val score: Double?,
//     @SerialName("scored_by")
//     val scoredBy: Long?,
//     val rank: Long?,
//     val popularity: Long,
//     val members: Long,
//     val favorites: Long,
//     val synopsis: String?,
//     val background: String,
//     val season: String?,
//     val year: Long?,
//     val broadcast: Broadcast,
//     val producers: List<Producer>,
//     val licensors: List<Licensor>,
//     val studios: List<Studio>,
//     val genres: List<Genre>,
//     @SerialName("explicit_genres")
//     val explicitGenres: List<Any?>,
//     val themes: List<Theme>,
//     val demographics: List<Demographic>,
// )

// @Serializable
// data class Images(
//     val jpg: Jpg,
//     val webp: Webp,
// )

// @Serializable
// data class Jpg(
//     @SerialName("image_url")
//     val imageUrl: String,
//     @SerialName("small_image_url")
//     val smallImageUrl: String,
//     @SerialName("large_image_url")
//     val largeImageUrl: String,
// )

// @Serializable
// data class Webp(
//     @SerialName("image_url")
//     val imageUrl: String,
//     @SerialName("small_image_url")
//     val smallImageUrl: String,
//     @SerialName("large_image_url")
//     val largeImageUrl: String,
// )

// @Serializable
// data class Trailer(
//     @SerialName("youtube_id")
//     val youtubeId: String?,
//     val url: String?,
//     @SerialName("embed_url")
//     val embedUrl: String?,
//     val images: Images2,
// )

// @Serializable
// data class Images2(
//     @SerialName("image_url")
//     val imageUrl: String?,
//     @SerialName("small_image_url")
//     val smallImageUrl: String?,
//     @SerialName("medium_image_url")
//     val mediumImageUrl: String?,
//     @SerialName("large_image_url")
//     val largeImageUrl: String?,
//     @SerialName("maximum_image_url")
//     val maximumImageUrl: String?,
// )

// @Serializable
// data class Title(
//     val type: String,
//     val title: String,
// )

// @Serializable
// data class Aired(
//     val from: String,
//     val to: String?,
//     val prop: Prop,
//     val string: String,
// )

// @Serializable
// data class Prop(
//     val from: From,
//     val to: To,
// )

// @Serializable
// data class From(
//     val day: Long,
//     val month: Long,
//     val year: Long,
// )

// @Serializable
// data class To(
//     val day: Long?,
//     val month: Long?,
//     val year: Long?,
// )

// @Serializable
// data class Broadcast(
//     val day: String?,
//     val time: String?,
//     val timezone: String?,
//     val string: String?,
// )

// @Serializable
// data class Producer(
//     @SerialName("mal_id")
//     val malId: Long,
//     val type: String,
//     val name: String,
//     val url: String,
// )

// @Serializable
// data class Licensor(
//     @SerialName("mal_id")
//     val malId: Long,
//     val type: String,
//     val name: String,
//     val url: String,
// )

// @Serializable
// data class Studio(
//     @SerialName("mal_id")
//     val malId: Long,
//     val type: String,
//     val name: String,
//     val url: String,
// )

// @Serializable
// data class Genre(
//     @SerialName("mal_id")
//     val malId: Long,
//     val type: String,
//     val name: String,
//     val url: String,
// )

// @Serializable
// data class Theme(
//     @SerialName("mal_id")
//     val malId: Long,
//     val type: String,
//     val name: String,
//     val url: String,
// )

// @Serializable
// data class Demographic(
//     @SerialName("mal_id")
//     val malId: Long,
//     val type: String,
//     val name: String,
//     val url: String,
// )
