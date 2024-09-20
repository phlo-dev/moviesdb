package br.com.data.repository

import br.com.data.remote.MoviesRemoteDataSource
import br.com.domain.repository.MovieRepository
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val remoteDataSource: MoviesRemoteDataSource,
) : MovieRepository {

    override fun getMovies(page: Int, genreId: Int?) = flow {
        emit(remoteDataSource.getMovies(page, genreId).map { movies -> movies.toDomain() })
    }

}