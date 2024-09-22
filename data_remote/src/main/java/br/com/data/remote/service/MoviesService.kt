package br.com.data.remote.service

import br.com.data.remote.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET(MOVIES_PATH)
    suspend fun getMovies(
        @Query(PAGE_QUERY) page: Int,
//        @Query(GENRE_MOVIES_QUERY) genreId: String
    ): MovieListResponse

    @GET(SEARCH_PATH)
    suspend fun searchMovieByQuery(
        @Query(SEARCH_QUERY) query: String,
        @Query(PAGE_QUERY) page: Int
    ): MovieListResponse
}