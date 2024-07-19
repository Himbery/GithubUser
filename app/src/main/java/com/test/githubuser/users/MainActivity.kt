package com.test.githubuser.users

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.githubuser.MyApplication
import com.test.githubuser.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    @Inject
    lateinit var viewModel: UsersViewModel

    val usersList = ArrayList<ItemUser>()

    override fun onCreate(savedInstanceState: Bundle?) {

        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter()
        binding.listMain.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = userAdapter
        }

        binding.searchBtn.setOnClickListener {
            if (binding.editFollowers.text.length > 0) {
                viewModel.getUsersByName(binding.editFollowers.text.toString())

                observeViewModel()
            }
        }
    }

    private fun observeViewModel() {

        viewModel.usersListLiveData.observe(this) { users ->
            users?.let {
                usersList.addAll(it)
                userAdapter.setUserData(it)
            }
        }
    }
}