package com.heepov.movielist.presentation.movies

import com.heepov.movielist.domain.models.Movie
import com.heepov.movielist.ui.movies.models.MoviesState

interface MoviesView {
    // Методы, меняющие внешний вид экрана

    fun render(state: MoviesState)


//    // Состояние «загрузки»
//    fun showLoading()
//
//    // Состояние «ошибки»
//    fun showError(errorMessage: String)
//
//    // Состояние «пустого списка»
//    fun showEmpty(emptyMessage: String)
//
//    // Состояние «контента»
//    fun showContent(movies: List<Movie>)

    // Методы «одноразовых событий»

    fun showToast(additionalMessage: String)
}