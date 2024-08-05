package com.heepov.movielist.ui.poster

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.heepov.movielist.R
import com.heepov.movielist.presentation.poster.PosterPresenter
import com.heepov.movielist.presentation.poster.PosterView
import com.heepov.movielist.util.Creator

class PosterActivity : Activity(), PosterView {

    private lateinit var posterPresenter: PosterPresenter
    private lateinit var poster: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poster)

        val posterUrl = intent.extras?.getString("poster", "")
        posterPresenter = Creator.providePosterPresenter(this, posterUrl.toString())

        poster = findViewById(R.id.poster)
        posterPresenter.onCreate()
    }

    override fun setupPosterImage(url: String) {
        Glide.with(applicationContext).load(url).into(poster)
    }
}