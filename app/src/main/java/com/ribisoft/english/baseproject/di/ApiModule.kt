package com.ribisoft.english.baseproject.di

import com.ribisoft.english.baseproject.data.api.*
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideNewsApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    fun provideAdsApi(retrofit: Retrofit): AdsApi {
        return retrofit.create(AdsApi::class.java)
    }
    fun provideConfigApi(retrofit: Retrofit): ConfigApi {
        return retrofit.create(ConfigApi::class.java)
    }

    fun provideNotifyApi(retrofit: Retrofit): NotifyApi {
        return retrofit.create(NotifyApi::class.java)
    }
    fun provideSearchApi(retrofit: Retrofit): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }

    single { provideNewsApi(get(named("News"))) }
    single { provideAdsApi(get(named("Ads"))) }
    single { provideConfigApi(get(named("Config"))) }
    single { provideNotifyApi(get(named("Notify"))) }
    single { provideSearchApi(get(named("Search"))) }
}