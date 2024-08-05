package com.heepov.movielist.presentation.poster

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.heepov.movielist.R
import com.heepov.movielist.presentation.movies.MoviesView

class PosterPresenter(
    private val view: PosterView,
    private val url: String,
) {

    fun onCreate() {
        view.setupPosterImage(url)
    }
}