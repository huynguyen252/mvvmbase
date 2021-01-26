package com.ribisoft.english.baseproject.data.repo

import android.content.Context
import com.ribisoft.english.baseproject.data.api.Api
import com.ribisoft.english.baseproject.data.model.request.HomeReqEntity
import com.ribisoft.english.baseproject.data.model.response.HomeResEntity
import com.ribisoft.english.baseproject.utils.AppResult
import com.ribisoft.english.baseproject.utils.NetworkManager.isOnline
import com.ribisoft.english.baseproject.utils.Utils.handleApiError
import com.ribisoft.english.baseproject.utils.Utils.handleSuccess
import com.ribisoft.english.baseproject.utils.noNetworkConnectivityError

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */

interface HomeRepo {
    suspend fun getHome(postEntity: HomeReqEntity): AppResult<HomeResEntity>
}

class HomeRepoImpl(private val context: Context, private val api: Api) : HomeRepo {

    override suspend fun getHome(postEntity: HomeReqEntity): AppResult<HomeResEntity> {
        return if (isOnline(context)) {
            try {
                val response = api.getHome(postEntity)
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
}