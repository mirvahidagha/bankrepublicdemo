package com.bank.demo.retrofit

import com.bank.demo.models.ResultItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {
    @GET("data.json")
    suspend fun getResult(): Response<List<ResultItem>>

}