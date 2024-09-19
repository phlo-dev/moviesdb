package br.com.moviesv2

import android.app.Application
import br.com.di.appModuleList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MoviesApplication)
            modules(appModuleList)
        }
    }
}