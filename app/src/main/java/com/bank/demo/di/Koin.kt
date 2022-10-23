package com.bank.demo.di

import com.bank.demo.retrofit.RetrofitServices
import com.bank.demo.viewmodels.CashViewmodel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://www.azn.az/data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitServices::class.java)}
}

val viewModelModule = module {
    factory { CashViewmodel(get()) }
}