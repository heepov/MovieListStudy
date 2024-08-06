package com.heepov.movielist.ui.movies.models

import com.heepov.movielist.domain.models.Movie

data class MoviesState(
    val movies: List<Movie>,
    val isLoading: Boolean,
    val errorMessage: String?
)