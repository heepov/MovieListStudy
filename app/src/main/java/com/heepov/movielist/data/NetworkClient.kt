package com.heepov.movielist.data

import com.heepov.movielist.data.dto.Response


interface NetworkClient {
    fun doRequest(dto: Any): Response
}