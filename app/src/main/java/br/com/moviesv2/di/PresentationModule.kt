package br.com.moviesv2.di

import br.com.moviesv2.presentation.features.home.MoviesHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MoviesHomeViewModel(getMoviesUseCase = get()) }
}