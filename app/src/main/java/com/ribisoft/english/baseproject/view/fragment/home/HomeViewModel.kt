package com.ribisoft.english.baseproject.view.fragment.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ribisoft.english.baseproject.data.model.remote.request.HomeReqEntity
import com.ribisoft.english.baseproject.data.model.remote.response.HomeResEntity
import com.ribisoft.english.baseproject.data.repo.HomeRepoImpl
import com.ribisoft.english.baseproject.utils.AppResult
import com.ribisoft.english.baseproject.view.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by HuyNguyenCao on 12/31/2020.
 */
class HomeViewModel(application: Application,private val repository:HomeRepoImpl) : BaseViewModel(application) {

    var homeResEntity = MutableLiveData<HomeResEntity>()

    fun getHomeRes(homeReqEntity: HomeReqEntity) {
        viewModelScope.launch {
            when (val result = repository.getHome(homeReqEntity)) {
                is AppResult.Success -> {
                    homeResEntity.value = result.successData
                    showError.value = null
                }
                is AppResult.Error -> {
                    showError.value = result.exception.message
                }
            }
        }
    }

}