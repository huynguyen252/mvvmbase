package com.ribisoft.english.baseproject.view.activity.main

import com.ribisoft.english.baseproject.R
import com.ribisoft.english.baseproject.databinding.ActivityMainBinding
import com.ribisoft.english.baseproject.view.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutRes: Int = R.layout.activity_main
    override val viewModel by viewModel<MainViewModel>()

    override fun initView() {
        viewDataBinding.viewModel = viewModel
    }

    override fun observeData() {

    }

    override fun initEvent() {

    }

}