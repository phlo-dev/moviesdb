package br.com.data.remote.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MovieDataTest {

    @Test
    fun `should convert MovieData to Movie`() {
        val expectedMovie = movieStub
        val movieResponse = movieResponseStub

        val actualMovie = movieResponse.toData()
        assertEquals(expectedMovie, actualMovie)
    }
}