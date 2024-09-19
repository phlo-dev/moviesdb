package br.com.di

import br.com.domain.usecases.GetMoviesUseCase
import br.com.domain.usecases.GetMoviesUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<GetMoviesUseCase> {
        GetMoviesUseCaseImpl(repository = get())
    }

}