package com.ribisoft.english.baseproject.di

import android.content.Context
import com.ribisoft.english.baseproject.data.api.AdsApi
import com.ribisoft.english.baseproject.data.api.NewsApi
import com.ribisoft.english.baseproject.data.repo.HomeRepoImpl
import com.ribisoft.english.baseproject.data.repo.MainRepoImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {

    fun provideMainRepository(context: Context,api: NewsApi): MainRepoImpl {
        return MainRepoImpl(context,api)
    }

    fun provideHomeRepository(context: Context,newsApi: NewsApi,adsApi: AdsApi): HomeRepoImpl {
        return HomeRepoImpl(context,newsApi,adsApi)
    }

    single { provideMainRepository(get(),get()) }
    single { provideHomeRepository(get(),get(),get()) }

}