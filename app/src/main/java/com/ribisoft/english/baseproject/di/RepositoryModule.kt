package com.ribisoft.english.baseproject.di

import android.content.Context
import com.ribisoft.english.baseproject.data.api.Api
import com.ribisoft.english.baseproject.data.repo.HomeRepoImpl
import com.ribisoft.english.baseproject.data.repo.MainRepoImpl
import org.koin.dsl.module

val repositoryModule = module {

    fun provideMainRepository(context: Context,api: Api): MainRepoImpl {
        return MainRepoImpl(context,api)
    }

    fun provideHomeRepository(context: Context, api: Api): HomeRepoImpl {
        return HomeRepoImpl(context,api)
    }

    single { provideMainRepository(get(),get()) }
    single { provideHomeRepository(get(),get()) }

}