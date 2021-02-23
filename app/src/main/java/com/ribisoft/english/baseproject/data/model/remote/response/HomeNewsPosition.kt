package com.ribisoft.english.baseproject.data.model.remote.response

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.ribisoft.english.baseproject.data.model.remote.response.Data

class HomeNewsPosition {
    @SerializedName("Data")
    @Expose
    var data: List<Data>? = null

}