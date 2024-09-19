package br.com.moviesv2.presentation

import br.com.domain.model.Movie

sealed class MoviesHomeUiState {
    data class Success(val movies: List<Movie>) : MoviesHomeUiState()
    data class Error(val throwable: Throwable) : MoviesHomeUiState()
    data object Loading : MoviesHomeUiState()
    data object Neutral : MoviesHomeUiState()
}
