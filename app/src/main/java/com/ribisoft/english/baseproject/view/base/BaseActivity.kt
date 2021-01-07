package com.ribisoft.english.baseproject.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
abstract class BaseActivity<T:ViewDataBinding> : AppCompatActivity(){

    abstract val layoutRes:Int
    abstract val viewModel:AndroidViewModel
    lateinit var viewDataBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this,layoutRes)
        initView()
        initEvent()
        observeData()
    }

    abstract fun initView()

    abstract fun initEvent()

    abstract fun observeData()

}