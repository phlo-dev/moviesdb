package br.com.moviesv2.presentation.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.domain.model.Movie
import br.com.domain.usecases.GetMoviesUseCase
import br.com.moviesv2.presentation.features.home.MoviesHomeUiState.Error
import br.com.moviesv2.presentation.features.home.MoviesHomeUiState.Loading
import br.com.moviesv2.presentation.features.home.MoviesHomeUiState.Neutral
import br.com.moviesv2.presentation.features.home.MoviesHomeUiState.Success
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.plus

@OptIn(ExperimentalCoroutinesApi::class)
class MoviesHomeViewModel(
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val getMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {
    private val movieList = mutableListOf<Movie>()
    private val _pageFlow = MutableStateFlow(1)
    val uiState: StateFlow<MoviesHomeUiState> = _pageFlow.flatMapLatest(::getMoviesState).stateIn(
        scope = viewModelScope.plus(coroutineDispatcher),
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = Neutral
    )

    private fun getMoviesState(page: Int) = getMoviesUseCase.invoke(page).map { result ->
        val movies = result.getOrNull()?.results?.also { movieList += it }
        val throwable = result.exceptionOrNull()
        when {
            movies != null -> Success(movieList)
            throwable != null -> Error(throwable)
            else -> Loading
        }
    }

    fun fetchMovies() = _pageFlow.value++

    fun refreshMovies() {
        movieList.clear()
        _pageFlow.value = 1
    }

}
