package br.com.di

import br.com.data.repository.MovieRepositoryImpl
import br.com.domain.repository.MovieRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModule = module {
    factoryOf(::MovieRepositoryImpl) bind MovieRepository::class
}