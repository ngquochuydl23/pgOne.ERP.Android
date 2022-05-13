package com.pgone.employee.repositories

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface IHttpClient {
    val httpClient: OkHttpClient.Builder
        get() = OkHttpClient.Builder()

    val retrofit: Retrofit
        get() = retrofitBuilder("http://103.53.228.214:21345/api/")

    private fun retrofitBuilder(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(httpClient.build())
            .build()
    }
}