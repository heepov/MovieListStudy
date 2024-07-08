package com.heepov.movielist

import com.google.gson.annotations.SerializedName


data class MoviesSearchResponse(
    @SerializedName("Search") val results: List<Movie>
)