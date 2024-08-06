package com.heepov.movielist

import android.app.Application
import com.heepov.movielist.presentation.movies.MoviesSearchPresenter

class MoviesApplication : Application() {

    var moviesSearchPresenter : MoviesSearchPresenter? = null

}