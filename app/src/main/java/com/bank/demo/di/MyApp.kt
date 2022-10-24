package com.bank.demo.di

import android.app.Application
import com.bank.demo.di.retrofitModule
import com.bank.demo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin


class MyApp: Application() {


    val moduleList = listOf(retrofitModule, viewModelModule)

// start koin with the module list

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(moduleList)
        }
    }

}