package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.midascategory.model.UserProduct
import com.example.midascategory.repositotry.MainActivityRepository


class MainActivityViewModel : ViewModel() {

    var ProductLiveData: MutableLiveData<UserProduct>? = null

    fun userProduct(): LiveData<UserProduct>? {

        ProductLiveData = MainActivityRepository.userProduct()
        return ProductLiveData
    }

}