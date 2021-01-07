package com.ribisoft.english.baseproject.app

import android.app.Application
import com.ribisoft.english.baseproject.di.apiModule
import com.ribisoft.english.baseproject.di.networkModule
import com.ribisoft.english.baseproject.di.repositoryModule
import com.ribisoft.english.baseproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(
                    apiModule,
                    viewModelModule,
                    repositoryModule,
                    networkModule,
            )
        }
    }
}