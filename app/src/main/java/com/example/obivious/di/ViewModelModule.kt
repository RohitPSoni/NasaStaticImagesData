package com.example.obivious.di

import com.example.obivious.ui.nasaImageList.NasaImageListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ NasaImageListViewModel(get()) }
}