package com.ribisoft.english.baseproject.view.fragment.parent

import android.app.Application
import com.ribisoft.english.baseproject.data.api.NewsApi
import com.ribisoft.english.baseproject.view.base.BaseViewModel

/**
 * Created by HuyNguyenCao on 12/31/2020.
 */
class ParentViewModel (application: Application,val repository:NewsApi) : BaseViewModel(application) {
}