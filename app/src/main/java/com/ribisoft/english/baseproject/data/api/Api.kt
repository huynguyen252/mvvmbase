package com.ribisoft.english.baseproject.data.api

import com.ribisoft.english.baseproject.data.model.request.HomeReqEntity
import com.ribisoft.english.baseproject.data.model.response.HomeResEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
interface Api {
    @POST("home")
    suspend fun getHome(@Body postEntity: HomeReqEntity): Response<HomeResEntity>
}