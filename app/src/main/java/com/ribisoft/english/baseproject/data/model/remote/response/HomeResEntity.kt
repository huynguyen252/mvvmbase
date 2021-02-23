package com.ribisoft.english.baseproject.data.model.remote.response

import com.google.gson.annotations.SerializedName
import com.ribisoft.english.baseproject.data.model.remote.response.HomeNewsPosition

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
data class HomeResEntity(
        @SerializedName("HomeNewsPosition")
        val homeNewsPosition: HomeNewsPosition?,
)