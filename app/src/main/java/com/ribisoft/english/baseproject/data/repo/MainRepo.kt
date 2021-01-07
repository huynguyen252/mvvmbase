package com.ribisoft.english.baseproject.data.repo

import android.content.Context
import android.util.Log
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

interface MainRepo {

}

class MainRepoImpl(private val context: Context, private val api: NewsApi) : MainRepo {

}