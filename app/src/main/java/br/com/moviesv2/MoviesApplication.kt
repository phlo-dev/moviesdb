package br.com.moviesv2

import android.app.Application
import br.com.moviesv2.di.appModuleList
import com.google.android.material.color.DynamicColors
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
        startKoin {
            androidContext(this@MoviesApplication)
            modules(appModuleList)
        }
    }
}