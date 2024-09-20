package br.com.moviesv2.di

import br.com.di.dataSourceModule
import br.com.di.domainModule
import br.com.di.remoteDataSourceModule

val appModuleList = listOf(
    presentationModule,
    remoteDataSourceModule,
    dataSourceModule,
    domainModule,
)