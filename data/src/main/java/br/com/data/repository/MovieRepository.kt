package br.com.data.repository

import br.com.data.model.MovieListData
import br.com.data.remote.MoviesRemoteDataSource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(page: Int, genreId: Int? = null): Flow<Result<MovieListData>>

    companion object {
        fun create(
            remoteDataSource: MoviesRemoteDataSource,
        ): MovieRepository = MovieRepositoryImpl(
            remoteDataSource = remoteDataSource,
        )
    }
}