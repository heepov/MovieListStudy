package com.heepov.movielist.util

import android.app.Activity
import android.content.Context
import com.heepov.movielist.data.MoviesRepositoryImpl
import com.heepov.movielist.data.network.RetrofitNetworkClient
import com.heepov.movielist.domain.api.MoviesInteractor
import com.heepov.movielist.domain.api.MoviesRepository
import com.heepov.movielist.domain.impl.MoviesInteractorImpl
import com.heepov.movielist.presentation.movies.MoviesSearchPresenter
import com.heepov.movielist.presentation.poster.PosterPresenter
import com.heepov.movielist.presentation.movies.MoviesView
import com.heepov.movielist.presentation.poster.PosterView

object Creator {
    private fun getMoviesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
    }

    fun provideMoviesInteractor(context: Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository(context))
    }


    fun provideMoviesSearchPresenter(
        context: Context,
    ): MoviesSearchPresenter {
        return MoviesSearchPresenter(
            context = context,
        )
    }

    fun providePosterPresenter(
        posterView: PosterView,
        url: String,
        ): PosterPresenter {
        return PosterPresenter(
            view = posterView,
            url = url,
        )
    }
}