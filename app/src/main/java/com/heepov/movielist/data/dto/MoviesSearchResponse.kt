package com.heepov.movielist.data.dto

import com.google.gson.annotations.SerializedName

class MoviesSearchResponse(
    val searchType: String,
    val expression: String,
    @SerializedName("Search") val results: List<MovieDto>
) : Response()