package br.com.domain.usecases

import br.com.domain.repository.MovieRepository

class GetMoviesUseCaseImpl(
    private val repository: MovieRepository
) : GetMoviesUseCase {

    override fun invoke(page: Int) =
        repository.getMovies(page = page)
}