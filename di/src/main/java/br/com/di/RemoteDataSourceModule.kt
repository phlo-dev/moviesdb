package br.com.di

import br.com.data.remote.MoviesRemoteDataSource
import br.com.data.remote.RequestInterceptor
import br.com.data.remote.datasource.MoviesRemoteDataSourceImpl
import br.com.data.remote.factory.ServiceClientFactory
import br.com.data.remote.service.BASE_URL
import br.com.data.remote.service.MoviesService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteDataSourceModule = module {
    singleOf(ServiceClientFactory::createHttpLoggingInterceptor) bind HttpLoggingInterceptor::class
    singleOf(ServiceClientFactory::createOkHttpClient) bind OkHttpClient::class

    singleOf(::RequestInterceptor)

    single {
        ServiceClientFactory.createService<MoviesService>(
            url = BASE_URL,
            okHttpClient = get()
        )
    }

    factoryOf(::MoviesRemoteDataSourceImpl) bind MoviesRemoteDataSource::class
}