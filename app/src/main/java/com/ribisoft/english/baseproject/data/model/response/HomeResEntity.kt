package com.ribisoft.english.baseproject.data.model.response

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
data class HomeResEntity(
        @SerializedName("HomeNewsPosition")
        val homeNewsPosition: HomeNewsPosition?,
)