package com.heepov.movielist.presentation.movies

import com.heepov.movielist.domain.models.Movie

interface MoviesView {
//    fun showPlaceholderMessage(isVisible: Boolean)
//
//    fun showMoviesList(isVisible: Boolean)
//
//    fun showProgressBar(isVisible: Boolean)
//
//    fun changePlaceholderText(newPlaceholderText: String)
//
//    fun updateMoviesList(newMoviesList: List<Movie>)
//
//    fun showToastMessage(message: String)

    // Состояние «загрузки»
    fun showLoading()

    // Состояние «ошибки»
    fun showError(errorMessage: String)

    // Состояние «пустого списка»
    fun showEmpty(emptyMessage: String)

    // Состояние «контента»
    fun showContent(movies: List<Movie>)

    // Методы «одноразовых событий»

    fun showToast(additionalMessage: String)
}