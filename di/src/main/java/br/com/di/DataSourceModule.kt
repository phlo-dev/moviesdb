package br.com.di

import br.com.data.repository.MovieRepository
import org.koin.dsl.module

val dataSourceModule = module {
    factory<MovieRepository> { MovieRepository.create(remoteDataSource = get ()) }

}