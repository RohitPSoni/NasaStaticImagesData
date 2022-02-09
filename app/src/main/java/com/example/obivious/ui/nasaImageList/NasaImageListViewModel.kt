package com.example.obivious.ui.nasaImageList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.obivious.base.BaseViewModel
import com.example.obivious.repo.NasaInfo
import com.example.obivious.repo.ShowListRepository
import com.example.obivious.ui.nasaImageList.data.NasaImage
import kotlinx.coroutines.launch

class NasaImageListViewModel(
    private val repo: ShowListRepository
): BaseViewModel() {
    val list = MutableLiveData<List<NasaImage>>()
    fun getList() {
        viewModelScope.launch {
            showProgress()
            when(val data = repo.getAllList()) {
                is NasaInfo.NasaInformation -> list.postValue(data.nasaList)
                is NasaInfo.Error -> showErrorMessage(data.throwable?.localizedMessage)
            }
            hideProgress()
        }
    }
}