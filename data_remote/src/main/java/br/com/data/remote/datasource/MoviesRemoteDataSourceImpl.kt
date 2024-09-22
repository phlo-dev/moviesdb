package br.com.data.remote.datasource

import br.com.data.model.MovieListData
import br.com.data.remote.MoviesRemoteDataSource
import br.com.data.remote.model.MovieListError
import br.com.data.remote.service.MoviesService
import kotlinx.serialization.json.Json
import retrofit2.HttpException

class MoviesRemoteDataSourceImpl(
    private val moviesApi: MoviesService
) : MoviesRemoteDataSource {
    override suspend fun getMovies(page: Int, genreId: Int?): Result<MovieListData> {
        try {
            val data = moviesApi.getMovies(page = page, /*genreId = "${genreId ?: ""}"*/).toData()
            return Result.success(data)
        } catch (e: Exception) {
            val exception = Exception(e.apiMessage ?: MOVIES_ERROR_LOAD, e)
            return Result.failure(exception)
        }
    }

    private val Throwable.apiMessage: String?
        get() {
            try {
                if (this !is HttpException) return null
                val jsonError = response()?.errorBody()?.string() ?: return null
                val error = Json.decodeFromString<MovieListError>(jsonError)
                return "error: ${error.statusCode} - ${error.statusMessage}"
            } catch (ignored: IllegalArgumentException) {
                return null
            }
        }

    companion object {
        const val MOVIES_ERROR_LOAD = "Falha ao tentar carregar filmes"
    }
}