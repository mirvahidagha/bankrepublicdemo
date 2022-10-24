package com.bank.demo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AznViewmodel: ViewModel() {

    val azn: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

}