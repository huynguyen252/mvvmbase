package com.ribisoft.english.baseproject.view.activity.main

import android.app.Application
import com.ribisoft.english.baseproject.data.repo.MainRepoImpl
import com.ribisoft.english.baseproject.view.base.BaseViewModel

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
class MainViewModel(application: Application, private val repository: MainRepoImpl) : BaseViewModel(application) {

}