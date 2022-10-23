package com.bank.demo.viewmodels

import androidx.lifecycle.*
import com.bank.demo.models.ResultItem
import com.bank.demo.retrofit.RetrofitServices

class CashViewmodel (private val retrofitServices: RetrofitServices) : ViewModel() {

     var currencyLiveData: LiveData<List<ResultItem>> = liveData {
         retrofitServices.getResult().body()?.let { emit(it) }
     }


}