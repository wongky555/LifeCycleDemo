package com.example.lifecycledemo.mymodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel: ViewModel() {

    var myValue = MutableLiveData<Int>()
    var myName = MutableLiveData<String>()
}