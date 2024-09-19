package br.com.data.repository

import br.com.data.remote.MoviesRemoteDataSource
import kotlinx.coroutines.flow.flow

internal class MovieRepositoryImpl(
    private val remoteDataSource: MoviesRemoteDataSource,
) : MovieRepository {

    override fun getMovies(page: Int, genreId: Int?) = flow {
        emit(remoteDataSource.getMovies(page, genreId))
    }

}