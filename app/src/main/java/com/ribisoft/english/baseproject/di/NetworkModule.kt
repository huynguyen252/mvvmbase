package com.ribisoft.english.baseproject.di

import com.ribisoft.english.baseproject.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
val networkModule = module {
    val connectTimeout: Long = 40// 20s
    val readTimeout: Long = 40 // 20s

    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    fun provideHeaderInterceptor(): Interceptor {
        return object : Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val request: Request = chain.request().newBuilder().build()
                return chain.proceed(request)
            }
        }
    }

    fun provideHttpClient(
        headerInterceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS).build()
    }

    fun provideRetrofit(client: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    single { provideHttpLoggingInterceptor() }

    single { provideHeaderInterceptor() }
    single { provideHttpClient(get(), get()) }
    single { provideRetrofit(get(), Constants.BASE_URL) }

}