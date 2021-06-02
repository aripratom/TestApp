package com.example.testapp.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.data.model.UserData
import com.example.testapp.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserBinding

    private lateinit var viewModel : UserViewModel

    lateinit var userAdapter: UserAdapter
    var listUser =  ArrayList<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getUser()

        userAdapter = UserAdapter(listUser)

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.rvUser.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = userAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.listUser.observe(this, Observer { list ->
            if (list.isNotEmpty()) {
                listUser.clear()
                listUser.addAll(list)
                userAdapter.notifyDataSetChanged()
            }
        })

    }
}