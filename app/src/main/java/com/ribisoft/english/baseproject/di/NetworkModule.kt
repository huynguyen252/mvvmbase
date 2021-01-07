package com.ribisoft.english.baseproject.di

import android.content.Context
import com.ribisoft.english.baseproject.utils.CommonUtils
import com.ribisoft.english.baseproject.utils.Constants
import com.ribisoft.english.baseproject.utils.Constants.TYPE_ADS
import com.ribisoft.english.baseproject.utils.Constants.TYPE_CONFIG
import com.ribisoft.english.baseproject.utils.Constants.TYPE_NEW
import com.ribisoft.english.baseproject.utils.Constants.TYPE_NOTIFY
import com.ribisoft.english.baseproject.utils.Constants.TYPE_SEARCH
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
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

    fun provideHeaderInterceptor(context: Context,type: Int): Interceptor {
        return object : Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                val request: Request
                val original = chain.request()
                request =
                    when (type) {
                        TYPE_NOTIFY -> {
                            val deviceId: String = CommonUtils.getDeviceId(context).toString()
                            val requestBuilder: Request.Builder = original.newBuilder()
                                .addHeader("session-id", deviceId)
                            requestBuilder.build()
                        }
                        TYPE_ADS -> {
                            val requestBuilder: Request.Builder = original.newBuilder()
                                .addHeader("Content-Type", "application/json; charset=utf-8")
                                .addHeader(
                                    "User-Agent",
                                    "Mozilla/5.0 (Linux; Android 7.0; SM-G570M Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/69.0.3497.100 Mobile Safari/537.36 Kenh14"
                                )
                            requestBuilder.build()
                        }
                        else -> {
                            chain.request().newBuilder().build()
                        }
                    }
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

    single(named("HeaderNews")) { provideHeaderInterceptor(get(),TYPE_NEW) }
    single(named("ClientNews")) { provideHttpClient(get(named("HeaderNews")), get()) }
    single(named("News")) { provideRetrofit(get(named("ClientNews")), Constants.BASE_URL_NEW) }

    single(named("HeaderNotify")) { provideHeaderInterceptor(get(),TYPE_NOTIFY) }
    single(named("ClientNotify")) { provideHttpClient(get(named("HeaderNotify")), get()) }
    single(named("Notify")) { provideRetrofit(get(named("ClientNotify")), Constants.BASE_URL_NOTIFY) }

    single(named("HeaderAds")) { provideHeaderInterceptor(get(),TYPE_ADS) }
    single(named("ClientAds")) { provideHttpClient(get(named("HeaderAds")), get()) }
    single(named("Ads")) { provideRetrofit(get(named("ClientAds")), Constants.BASE_URL_ADS) }

    single(named("HeaderConfig")) { provideHeaderInterceptor(get(),TYPE_CONFIG) }
    single(named("ClientConfig")) { provideHttpClient(get(named("HeaderConfig")), get()) }
    single(named("Config")) { provideRetrofit(get(named("ClientConfig")), Constants.BASE_URL_CONFIG) }

    single(named("HeaderSearch")) { provideHeaderInterceptor(get(), TYPE_SEARCH) }
    single(named("ClientSearch")) { provideHttpClient(get(named("HeaderSearch")), get()) }
    single(named("Search")) { provideRetrofit(get(named("ClientSearch")), Constants.BASE_URL_SEARCH) }
}