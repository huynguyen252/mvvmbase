package com.ribisoft.english.baseproject.view.base

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import com.ribisoft.english.baseproject.utils.SingleLiveEvent

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
abstract class BaseViewModel(application: Application) : AndroidViewModel(application){
    val showLoading = ObservableBoolean()
    val showError = SingleLiveEvent<String>()
}