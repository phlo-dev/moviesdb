package br.com.domain.usecases

import br.com.domain.model.MovieList
import kotlinx.coroutines.flow.Flow

interface GetMoviesUseCase {
    operator fun invoke(page: Int): Flow<Result<MovieList>>
}
