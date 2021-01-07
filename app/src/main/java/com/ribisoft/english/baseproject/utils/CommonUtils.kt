package com.ribisoft.english.baseproject.utils

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings

/**
 * Created by HuyNguyenCao on 1/4/2021.
 */
object CommonUtils {

    @SuppressLint("all")
    fun getDeviceId(context: Context): String? {
        return try {
            Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        } catch (e: Exception) {
            "-1"
        }
    }

}