package com.ribisoft.english.baseproject.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("ZoneId")
    @Expose
    var zoneId = 0

    @SerializedName("ZoneName")
    @Expose
    var zoneName: String? = null

    @SerializedName("ZoneShortURL")
    @Expose
    var zoneShortURL: String? = null

    @SerializedName("NewsId")
    @Expose
    var newsId: String? = null

    @SerializedName("Title")
    @Expose
    var title: String? = null

    @SerializedName("SubTitle")
    @Expose
    var subTitle: String? = null

    @SerializedName("Sapo")
    @Expose
    var sapo: String? = null

    @SerializedName("Url")
    @Expose
    var url: String? = null

    @SerializedName("Avatar")
    @Expose
    var avatar: String? = null

    @SerializedName("DistributionDate")
    @Expose
    var distributionDate: String? = null

    @SerializedName("NewsType")
    @Expose
    var newsType = 0

    @SerializedName("ThreadId")
    @Expose
    var threadId = 0

    @SerializedName("Order")
    @Expose
    var order = 0

    @SerializedName("Type")
    @Expose
    var type = 0

    @SerializedName("ThreadName")
    @Expose
    var threadName: String? = null

    @SerializedName("Id")
    @Expose
    var id: String? = null

    @SerializedName("SourceLink")
    @Expose
    var sourceLink: String? = null

    @SerializedName("AvatarPreload")
    @Expose
    var avatarPreload: String? = null

    @SerializedName("Source")
    @Expose
    var source: String? = null

    @SerializedName("CommentCount")
    @Expose
    var commentCount = 0

    @SerializedName("ShareCount")
    @Expose
    var shareCount = 0

    @SerializedName("Name")
    @Expose
    var name: String? = null

    @SerializedName("ShortURL")
    @Expose
    var shortURL: String? = null

    @SerializedName("InitSapo")
    @Expose
    var initSapo: String? = null

    @SerializedName("SocialCount")
    @Expose
    var socicalCount = 0

    @SerializedName("SocialType")
    @Expose
    var socialType: String? = null

    @SerializedName("CommentUrl")
    @Expose
    var commentUrl: String? = null
    var note: String? = null
    var isShowTitleNews = false
    var isShowRelatedList = false
    var isInitRelated = false
    var isShowNewest = false
    var isShowAdsNative = false
    var idAds = 0
    var boxID = 0
    var isCaring = false
    var isDontForget = false
    var isPlus = false
    var isPlusVideo = false
    var isNewZone = false
    var isAdsNewZone = false
    var isFirstItemNewZone = false
    var isLoadedRelation = false
    var videoZoneType = ""

    constructor() {}
    constructor(typeData: Int) {
        this.typeData = typeData
    }
    var typeData = 0
    var isShowRelation = false

}