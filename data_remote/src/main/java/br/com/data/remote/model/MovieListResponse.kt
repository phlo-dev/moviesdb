package br.com.data.remote.model

import br.com.data.model.MovieListData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val results: List<MovieResponse>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
) {

    fun toData(): MovieListData {
        return MovieListData(
            page,
            results.map { movie -> movie.toData() },
            totalPages,
            totalResults
        )
    }
}
