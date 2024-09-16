package br.com.data.repository

import br.com.data.model.MovieListData
import br.com.data.remote.MoviesRemoteDataSource
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMovies(page: Int, genreId: Int): Flow<Result<MovieListData>>

    companion object {
        fun create(
            remoteDataSource: MoviesRemoteDataSource,
        ): MoviesRepository = MoviesRepositoryImpl(
            remoteDataSource = remoteDataSource,
        )
    }
}