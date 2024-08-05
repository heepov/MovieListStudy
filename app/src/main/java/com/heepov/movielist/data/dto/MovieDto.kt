package com.heepov.movielist.data.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val description: String,
    @SerializedName("imdbID") val imdbID: String,
    @SerializedName("Type") val type: String,
    @SerializedName("Poster") val image: String,
)