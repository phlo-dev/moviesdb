package br.com.data.model

data class MovieListData(
    val page: Int,
    val results: List<MovieData>,
    val totalPages: Int,
    val totalResults: Int
)