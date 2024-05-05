package com.test.githubuser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersViewModel : ViewModel() {

    private var usersLiveData = MutableLiveData<List<ItemUser>>()

    fun getUsersByName() {
        RetrofitHelper.api.loadUserList("Firebase").enqueue(object : Callback<ListUser> {
            override fun onResponse(call: Call<ListUser>, response: Response<ListUser>) {
                response.body()?.let { usersList->
                    usersLiveData.postValue(usersList.items)
                }
            }

            override fun onFailure(call: Call<ListUser>, t: Throwable) {
                Log.i("TAG" , t.message.toString())
            }

        })
    }

    fun observeLiveData() : LiveData<List<ItemUser>> {
        return usersLiveData
    }
}