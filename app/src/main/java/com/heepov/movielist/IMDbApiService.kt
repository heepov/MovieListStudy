package com.heepov.movielist

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMDbApiService {
    @GET("/")
    fun findMovies(@Query("apikey") apiKey: String, @Query("s") expression: String): Call<MoviesSearchResponse>
}