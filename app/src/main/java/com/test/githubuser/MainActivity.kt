package com.test.githubuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    private lateinit var viewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter()
        binding.listMain.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = userAdapter
        }

        viewModel = ViewModelProvider(this)[UsersViewModel::class.java]
        viewModel.getUsersByName()
        viewModel.observeLiveData().observe(this , Observer {  it ->
            userAdapter.setUserData(it)
        })
    }
}