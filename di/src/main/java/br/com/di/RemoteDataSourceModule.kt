package br.com.di

import br.com.data.remote.MoviesRemoteDataSource
import br.com.data.remote.RequestInterceptor
import br.com.data.remote.datasource.MoviesRemoteDataSourceImpl
import br.com.data.remote.factory.ServiceClientFactory
import br.com.data.remote.service.BASE_URL
import br.com.data.remote.service.MoviesService
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { ServiceClientFactory.createHttpLoggingInterceptor() }

    single { ServiceClientFactory.createOkHttpClient(get(), get()) }

    single { RequestInterceptor() }

    single { ServiceClientFactory.createClient<MoviesService>(BASE_URL, get()) }

    factory<MoviesRemoteDataSource> { MoviesRemoteDataSourceImpl(get()) }
}