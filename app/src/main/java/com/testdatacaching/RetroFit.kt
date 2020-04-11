package com.testdatacaching

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroFit {
    val service: ApiServices

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ApiServices::class.java)
    }
}