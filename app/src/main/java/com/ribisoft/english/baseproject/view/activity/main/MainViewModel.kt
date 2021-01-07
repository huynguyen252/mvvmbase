package com.ribisoft.english.baseproject.view.activity.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ribisoft.english.baseproject.data.model.request.HomeReqEntity
import com.ribisoft.english.baseproject.data.model.response.HomeResEntity
import com.ribisoft.english.baseproject.data.repo.HomeRepoImpl
import com.ribisoft.english.baseproject.data.repo.MainRepoImpl
import com.ribisoft.english.baseproject.utils.AppResult
import com.ribisoft.english.baseproject.view.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
class MainViewModel(application: Application, private val repository: MainRepoImpl) : BaseViewModel(application) {

}