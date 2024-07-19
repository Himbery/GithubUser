package com.test.githubuser.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.githubuser.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private var usersLiveData = MutableLiveData<List<ItemUser>>()

    val usersListLiveData:LiveData<List<ItemUser>>
        get() = userRepository.userLiveData

    fun getUsersByName(name: String) {
        viewModelScope.launch {
            userRepository.getListOfUsers(name)
        }
    }
}