package com.example.learnandroidstart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    private val _data = MutableLiveData<String>()

    val data : LiveData<String>
        get() = _data

    fun setData(inputText : String){
        _data.value = inputText
    }
}