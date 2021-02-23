package com.ribisoft.english.baseproject.di

import com.ribisoft.english.baseproject.view.activity.main.MainViewModel
import com.ribisoft.english.baseproject.view.fragment.home.HomeViewModel
import com.ribisoft.english.baseproject.view.fragment.parent.ParentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(get(),get())
    }

    viewModel {
        ParentViewModel(get(),get())
    }

    viewModel {
        HomeViewModel(get(),get())
    }

}