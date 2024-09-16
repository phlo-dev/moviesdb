package br.com.data.remote.service

import br.com.data.remote.factory.ServiceClientFactory
import br.com.data.remote.model.MovieListResponse
import okhttp3.OkHttpClient
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET(MOVIES_PATH)
    suspend fun getMovies(
        @Query(PAGE_QUERY) page: Int,
        @Query(GENRE_MOVIES_QUERY) genreId: Int
    ): MovieListResponse

    @GET(SEARCH_PATH)
    suspend fun searchMovieByQuery(
        @Query(SEARCH_QUERY) query: String,
        @Query(PAGE_QUERY) page: Int
    ): MovieListResponse

    companion object {
        fun create(baseUrl: String, okHttpClient: OkHttpClient) =
            ServiceClientFactory.createClient<MoviesService>(
                url = baseUrl,
                okHttpClient = okHttpClient
            )
    }
}