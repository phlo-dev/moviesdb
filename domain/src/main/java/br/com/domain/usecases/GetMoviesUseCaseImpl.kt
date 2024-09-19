package br.com.domain.usecases

import br.com.data.repository.MovieRepository
import br.com.domain.model.MovieList
import kotlinx.coroutines.flow.map

class GetMoviesUseCaseImpl(
    private val repository: MovieRepository
) : GetMoviesUseCase {

    override fun invoke(page: Int) =
        repository.getMovies(page = page).map { result ->
            result.map { movieList ->
                MovieList.fromData(movieList)
            }
        }
}