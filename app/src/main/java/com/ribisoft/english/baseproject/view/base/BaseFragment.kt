package com.ribisoft.english.baseproject.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    abstract val layoutRes: Int
    abstract val viewModel: AndroidViewModel
    lateinit var viewDataBinding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        viewDataBinding.lifecycleOwner = this
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initEvent()
        observeData()
    }

    abstract fun initView()

    abstract fun initEvent()

    abstract fun observeData()

}