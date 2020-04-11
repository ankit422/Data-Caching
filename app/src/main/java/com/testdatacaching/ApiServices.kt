package com.testdatacaching

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("users/{user}/repos")
    open fun listRepos(@Path("user") user: String?): Call<MutableList<Repo>>
}