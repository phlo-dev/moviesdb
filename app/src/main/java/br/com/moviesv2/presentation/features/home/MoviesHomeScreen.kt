@file:OptIn(ExperimentalMaterial3Api::class)

package br.com.moviesv2.presentation.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.domain.model.Movie
import br.com.moviesv2.ui.ds.core.ScreenPreview
import org.koin.androidx.compose.koinViewModel


@Composable
fun MoviesHomeScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = { },
    viewModel: MoviesHomeViewModel = koinViewModel()
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()
    MoviesHomeContent(modifier = modifier, state = state.value)
}

@Composable
private fun MoviesHomeContent(
    modifier: Modifier = Modifier,
    state: MoviesHomeUiState
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            MoviesHomeTopBar()
        }
    ) {
        Spacer(Modifier.padding(it))

        when (state) {
            is MoviesHomeUiState.Error -> Text(text = "Error")
            is MoviesHomeUiState.Success -> MoviesList(movies = state.movies)
            MoviesHomeUiState.Loading -> Text(text = "Loading")
        }
    }
}

@Composable
private fun MoviesList(
    modifier: Modifier = Modifier,
    movies: List<Movie>
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(180.dp)
    ) {
        items(movies.size) { index ->
            MovieCard(movie = movies[index])
        }
    }
}

@Composable
fun MovieCard(
    modifier: Modifier = Modifier, movie: Movie
) {
    OutlinedCard(
        modifier = modifier
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = movie.title)
                Text(text = movie.releaseDate)
            }
        }
    }

}

@Composable
private fun MoviesHomeTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.primary,
            actionIconContentColor = MaterialTheme.colorScheme.primary,
            scrolledContainerColor = MaterialTheme.colorScheme.background,
            navigationIconContentColor = MaterialTheme.colorScheme.surfaceContainerHigh,
        ),
        title = {
            Text(
                text = "Movies",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }
        }
    )
}

@ScreenPreview
@Composable
private fun TestMoviesHomeScreenSuccess() {
    val movie = Movie(
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
    MoviesHomeContent(
        state = MoviesHomeUiState.Success(
            listOf(movie, movie, movie, movie, movie)
        )
    )
}

@ScreenPreview
@Composable
private fun TestMoviesHomeScreenError() {
    MoviesHomeContent(state = MoviesHomeUiState.Error(Throwable()))
}

@ScreenPreview
@Composable
private fun TestMoviesHomeScreenLoading() {
    MoviesHomeContent(state = MoviesHomeUiState.Loading)
}
