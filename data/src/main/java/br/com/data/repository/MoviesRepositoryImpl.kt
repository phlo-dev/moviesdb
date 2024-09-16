package br.com.data.repository

import br.com.data.remote.MoviesRemoteDataSource
import kotlinx.coroutines.flow.flow

internal class MoviesRepositoryImpl(
    private val remoteDataSource: MoviesRemoteDataSource,
) : MoviesRepository {

    override fun getMovies(page: Int, genreId: Int) = flow {
        emit(remoteDataSource.getMovies(page, genreId))
    }

}