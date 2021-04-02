package com.khazna.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel(){

    val loading = MutableLiveData(false)

}