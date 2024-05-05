package com.test.githubuser

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("/search/users")
    fun loadUserList(@Query("q") query: String): Call<ListUser>
}