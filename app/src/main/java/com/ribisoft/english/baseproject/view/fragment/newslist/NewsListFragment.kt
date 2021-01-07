package com.ribisoft.english.baseproject.view.fragment.newslist

import androidx.lifecycle.AndroidViewModel
import com.ribisoft.english.baseproject.R
import com.ribisoft.english.baseproject.databinding.FragmentHomeBinding
import com.ribisoft.english.baseproject.databinding.FragmentNewsListBinding
import com.ribisoft.english.baseproject.view.base.BaseFragment
import com.ribisoft.english.baseproject.view.fragment.home.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by HuyNguyenCao on 12/31/2020.
 */
class NewsListFragment : BaseFragment<FragmentNewsListBinding>() {

    override val layoutRes: Int = R.layout.fragment_news_list
    override val viewModel: AndroidViewModel by viewModel<NewsListViewModel>()

    override fun initView() {

    }

    override fun observeData() {

    }

    override fun initEvent() {

    }

}