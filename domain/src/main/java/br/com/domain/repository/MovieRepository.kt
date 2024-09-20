package br.com.domain.repository

import br.com.domain.model.MovieList
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(page: Int, genreId: Int? = null): Flow<Result<MovieList>>
}