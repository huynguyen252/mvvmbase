package com.ribisoft.english.baseproject.di

import com.ribisoft.english.baseproject.data.api.*
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideNewsApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    single { provideNewsApi(get()) }

}