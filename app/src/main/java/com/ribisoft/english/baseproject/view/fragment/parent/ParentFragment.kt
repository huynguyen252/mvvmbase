package com.ribisoft.english.baseproject.view.fragment.parent

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.ribisoft.english.baseproject.R
import com.ribisoft.english.baseproject.databinding.FragmentParentBinding
import com.ribisoft.english.baseproject.view.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by HuyNguyenCao on 12/31/2020.
 */
class ParentFragment : BaseFragment<FragmentParentBinding>() {
    override val layoutRes: Int = R.layout.fragment_parent
    override val viewModel: ParentViewModel by viewModel()

    override fun initView() {
        viewDataBinding.fragment = this
        viewDataBinding.viewModel = viewModel
    }

    override fun observeData() {

    }

    override fun initEvent() {

    }

    fun openHomeFragment() {
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        findNavController().navigate(R.id.homeFragment, null, options)
    }

}