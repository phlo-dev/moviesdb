package br.com.data.remote.model

import br.com.data.model.MovieData

val movieStub = MovieData(
    id = 1,
    title = "Movie Title",
    posterPath = "/poster.jpg",
    releaseDate = "2023-10-26",
    voteAverage = 7.5,
    voteCount = 1000,
    popularity = 85.5,
    originalLanguage = "en",
    originalTitle = "Original Movie Title",
    overview = "Movie overview",
    backdropPath = "/backdrop.jpg",
    genreIds = listOf(1, 2, 3),
    adult = false,
    video = false
)

val movieResponseStub = MovieResponse(
    id = 1,
    title = "Movie Title",
    posterPath = "/poster.jpg",
    releaseDate = "2023-10-26",
    voteAverage = 7.5,
    voteCount =  1000,
    popularity = 85.5,
    originalLanguage = "en",
    originalTitle = "Original Movie Title",
    overview = "Movie overview",
    backdropPath = "/backdrop.jpg",
    genreIds = listOf(1, 2, 3),
    adult = false,
    video = false
)