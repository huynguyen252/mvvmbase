package com.ribisoft.english.baseproject.data.repo

import android.content.Context
import android.util.Log
import com.ribisoft.english.baseproject.data.api.AdsApi
import com.ribisoft.english.baseproject.data.api.NewsApi
import com.ribisoft.english.baseproject.data.model.request.HomeReqEntity
import com.ribisoft.english.baseproject.data.model.response.HomeResEntity
import com.ribisoft.english.baseproject.utils.AppResult
import com.ribisoft.english.baseproject.utils.NetworkManager
import com.ribisoft.english.baseproject.utils.NetworkManager.isOnline
import com.ribisoft.english.baseproject.utils.Utils.handleApiError
import com.ribisoft.english.baseproject.utils.Utils.handleSuccess
import com.ribisoft.english.baseproject.utils.noNetworkConnectivityError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */

interface HomeRepo {
    suspend fun getHome(postEntity: HomeReqEntity): AppResult<HomeResEntity>
    suspend fun getAds(postEntity: HomeReqEntity): AppResult<HomeResEntity>
}

class HomeRepoImpl(private val context: Context, private val newsApi: NewsApi,private val adsApi: AdsApi) : HomeRepo {

    override suspend fun getHome(postEntity: HomeReqEntity): AppResult<HomeResEntity> {
        return if (isOnline(context)) {
            try {
                val response = newsApi.getHome(postEntity)
                if (response.isSuccessful) {
                    handleSuccess(response)
                } else {
                    handleApiError(response)
                }
            } catch (e: Exception) {
                AppResult.Error(e)
            }
        } else {
            context.noNetworkConnectivityError()
        }
    }

    override suspend fun getAds(postEntity: HomeReqEntity): AppResult<HomeResEntity> {
        TODO("Not yet implemented")
    }

}