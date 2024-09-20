package br.com.data.model

import br.com.domain.model.MovieList

data class MovieListData(
    val page: Int,
    val results: List<MovieData>,
    val totalPages: Int,
    val totalResults: Int
) {
    fun toDomain() = MovieList(
        page = page,
        results = results.map { movieData -> movieData.toDomain() },
        totalPages = totalPages,
        totalResults = totalResults,
    )
}