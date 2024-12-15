package com.test.githubuser

import com.test.githubuser.repos.ItemRepo
import com.test.githubuser.users.ListUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import javax.inject.Singleton

@Singleton
interface UserApi {

    @GET("/search/users")
    suspend fun loadUserList(@Query("q") query: String): Response<ListUser>

    @GET
    suspend fun loadRepos(@Url url : String) : Response<List<ItemRepo>>
}