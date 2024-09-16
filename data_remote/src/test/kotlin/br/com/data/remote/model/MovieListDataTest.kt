package br.com.data.remote.model

import br.com.data.model.MovieListData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MovieListDataTest {

    @Test
    fun `should convert MovieListData to MovieList`() {
        val expectedMovieList = MovieListData(
            page = 1,
            results = listOf(movieStub, movieStub, movieStub),
            totalPages = 10,
            totalResults = 3
        )
        val movieResponse = MovieListResponse(
            page = 1,
            results = listOf(movieResponseStub, movieResponseStub, movieResponseStub),
            totalPages = 10,
            totalResults = 3,
        )

        assertEquals(expectedMovieList, movieResponse.toData())
    }

}