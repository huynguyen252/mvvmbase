package com.ribisoft.english.baseproject.view.activity.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.ribisoft.english.baseproject.R
import com.ribisoft.english.baseproject.data.model.request.HomeReqEntity
import com.ribisoft.english.baseproject.databinding.ActivityMainBinding
import com.ribisoft.english.baseproject.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
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