package br.com.domain.model

import br.com.data.model.MovieListData

data class MovieList(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
) {
    companion object {
        fun fromData(movieList: MovieListData) = MovieList(
            page = movieList.page,
            results = movieList.results.map { Movie.fromData(it) },
            totalPages = movieList.totalPages,
            totalResults = movieList.totalResults,
        )
    }
}