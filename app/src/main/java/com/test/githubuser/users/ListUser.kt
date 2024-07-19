package com.test.githubuser.users

import com.google.gson.annotations.SerializedName

data class ListUser(
    @SerializedName("items")
    val items: List<ItemUser>
)
