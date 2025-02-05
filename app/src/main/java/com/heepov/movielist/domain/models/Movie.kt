package com.heepov.movielist.domain.models

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Poster") val image: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val description: String)