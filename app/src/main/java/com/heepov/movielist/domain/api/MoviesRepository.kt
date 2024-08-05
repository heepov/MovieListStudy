package com.heepov.movielist.domain.api

import com.heepov.movielist.domain.models.Movie
import com.heepov.movielist.util.Resource

interface MoviesRepository {
    fun searchMovies(expression: String): Resource<List<Movie>>
}