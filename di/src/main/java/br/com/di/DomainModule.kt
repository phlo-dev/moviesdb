package br.com.di

import br.com.domain.usecases.GetMoviesUseCase
import br.com.domain.usecases.GetMoviesUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    singleOf(::GetMoviesUseCaseImpl) bind GetMoviesUseCase::class

}