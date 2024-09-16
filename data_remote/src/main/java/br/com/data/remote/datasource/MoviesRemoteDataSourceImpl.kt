package br.com.data.remote.datasource

import br.com.data.model.MovieListData
import br.com.data.remote.MoviesRemoteDataSource
import br.com.data.remote.service.MoviesService

class MoviesRemoteDataSourceImpl(
    private val moviesApi: MoviesService
) : MoviesRemoteDataSource {
    override suspend fun getMovies(page: Int, genreId: Int): Result<MovieListData> {
        try {
            val data = moviesApi.getMovies(page = page, genreId = genreId).toData()
            return Result.success(data)
        } catch (e: Exception) {
            val exception = Exception(MOVIES_ERROR_LOAD, e)
            return Result.failure(exception)
        }
    }

    companion object {
        const val MOVIES_ERROR_LOAD = "Falha ao tentar carregar filmes"
    }
}