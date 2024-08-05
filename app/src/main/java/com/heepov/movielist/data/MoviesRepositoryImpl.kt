package com.heepov.movielist.data

import com.heepov.movielist.data.dto.MoviesSearchRequest
import com.heepov.movielist.data.dto.MoviesSearchResponse
import com.heepov.movielist.domain.api.MoviesRepository
import com.heepov.movielist.domain.models.Movie
import com.heepov.movielist.util.Resource

class MoviesRepositoryImpl(private val networkClient: NetworkClient) : MoviesRepository {

    override fun searchMovies(expression: String): Resource<List<Movie>> {
        val response = networkClient.doRequest(MoviesSearchRequest(expression))
        return when (response.resultCode) {
            -1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }
            200 -> {
                Resource.Success((response as MoviesSearchResponse).results.map {
                    Movie(it.image, it.title, it.description)
                })
            }
            else -> {
                Resource.Error("Ошибка сервера")
            }
        }
    }
}