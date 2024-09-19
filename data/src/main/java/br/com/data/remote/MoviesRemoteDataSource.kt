package br.com.data.remote

import br.com.data.model.MovieListData

interface MoviesRemoteDataSource {
    suspend fun getMovies(page: Int, genreId: Int? = null): Result<MovieListData>
}