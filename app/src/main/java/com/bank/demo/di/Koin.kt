package com.bank.demo.di

import com.bank.demo.retrofit.RetrofitServices
import com.bank.demo.retrofit.client.MyClient
import com.bank.demo.viewmodels.AznViewmodel
import com.bank.demo.viewmodels.CashViewmodel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://www.azn.az/data/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(MyClient(androidContext()).client)
            .build()
            .create(RetrofitServices::class.java)}

}

val viewModelModule = module {
    factory { CashViewmodel(get()) }
}

val aznModelModule = module {
    factory { AznViewmodel() }
}