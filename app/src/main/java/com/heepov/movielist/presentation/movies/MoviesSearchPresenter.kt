package com.heepov.movielist.presentation.movies

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heepov.movielist.R
import com.heepov.movielist.util.Creator
import com.heepov.movielist.domain.api.MoviesInteractor
import com.heepov.movielist.domain.models.Movie
import com.heepov.movielist.ui.movies.MoviesAdapter
import com.heepov.movielist.ui.movies.models.MoviesState

class MoviesSearchPresenter(
    private val view: MoviesView,
    private val context: Context,
) {
    companion object {
        private const val SEARCH_DEBOUNCE_DELAY = 2000L
    }

    private val moviesInteractor = Creator.provideMoviesInteractor(context)
    private val handler = Handler(Looper.getMainLooper())

    private var lastSearchText: String? = null
    private val movies = ArrayList<Movie>()

    private val searchRunnable = Runnable {
        val newSearchText = lastSearchText ?: ""
        searchRequest(newSearchText)
    }

    fun onDestroy() {
        handler.removeCallbacks(searchRunnable)
    }


    fun searchDebounce(changedText: String) {
        this.lastSearchText = changedText
        handler.removeCallbacks(searchRunnable)
        handler.postDelayed(searchRunnable, SEARCH_DEBOUNCE_DELAY)
    }

    private fun searchRequest(newSearchText: String) {
        if (newSearchText.isNotEmpty()) {
            view.render(
                MoviesState(
                    movies = movies,
                    isLoading = true,
                    errorMessage = null,
                )
            )
            moviesInteractor.searchMovies(
                newSearchText,
                object : MoviesInteractor.MoviesConsumer {
                    override fun consume(foundMovies: List<Movie>?, errorMessage: String?) {
                        handler.post {
                            if (foundMovies != null) {
                                movies.clear()
                                movies.addAll(foundMovies)
                            }
                            when {
                                errorMessage!= null -> {
                                    view.render(
                                        MoviesState(
                                            movies = emptyList(),
                                            isLoading = false,
                                            errorMessage = context.getString(R.string.something_went_wrong),
                                        )
                                    )
                                }
                                movies.isEmpty() -> {
                                    view.render(
                                        MoviesState(
                                            movies = emptyList(),
                                            isLoading = false,
                                            errorMessage = context.getString(R.string.nothing_found),
                                        )
                                    )
                                }
                                else -> {
                                    view.render(
                                        MoviesState(
                                            movies = movies,
                                            isLoading = false,
                                            errorMessage = null
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}