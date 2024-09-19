package br.com.moviesv2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.domain.model.Movie
import br.com.domain.usecases.GetMoviesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MoviesHomeViewModel(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val getMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {
    private var currentPage = 1
    private var totalPage = 1
    private val _uiState: MutableStateFlow<MoviesHomeUiState> =
        MutableStateFlow(MoviesHomeUiState.Neutral)
    private val movieList = mutableListOf<Movie>()
    val uiState: StateFlow<MoviesHomeUiState> = _uiState.asStateFlow()

    fun fetchMovies() {
        viewModelScope.launch(coroutineDispatcher) {
            if (totalPage >= currentPage) return@launch
            val flow = getMoviesUseCase.invoke(page = currentPage).map { result ->
                val movies = result.getOrNull()
                val throwable = result.exceptionOrNull()
                when {
                    movies != null -> {
                        movieList += movies.results
                        currentPage++
                        MoviesHomeUiState.Success(movieList)
                    }
                    throwable != null -> MoviesHomeUiState.Error(throwable)
                    else -> MoviesHomeUiState.Loading
                }
            }
            flow.collect { state ->
                _uiState.value = state
            }
        }
    }
}
