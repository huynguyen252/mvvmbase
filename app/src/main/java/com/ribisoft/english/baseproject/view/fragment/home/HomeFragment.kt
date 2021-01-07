package com.ribisoft.english.baseproject.view.fragment.home

import androidx.lifecycle.AndroidViewModel
import com.ribisoft.english.baseproject.R
import com.ribisoft.english.baseproject.databinding.FragmentHomeBinding
import com.ribisoft.english.baseproject.view.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by HuyNguyenCao on 12/31/2020.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val layoutRes: Int = R.layout.fragment_home
    override val viewModel: AndroidViewModel by viewModel<HomeViewModel>()

    override fun initView() {

    }

    override fun observeData() {

    }

    override fun initEvent() {

    }
}