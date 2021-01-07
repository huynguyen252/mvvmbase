package com.ribisoft.english.baseproject.data.model.response

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class HomeNewsPosition {
    @SerializedName("Data")
    @Expose
    var data: List<Data>? = null

}