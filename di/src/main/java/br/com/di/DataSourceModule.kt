package br.com.di

import br.com.data.repository.MoviesRepository
import org.koin.dsl.module

val dataSourceModule = module {
    factory<MoviesRepository> { MoviesRepository.create(remoteDataSource = get ()) }

}