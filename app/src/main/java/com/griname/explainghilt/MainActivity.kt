package com.griname.explainghilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.griname.explainghilt.data.User
import com.griname.explainghilt.data.UserViewModel
import com.griname.explainghilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserViewModel by viewModels()

    private var counter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.allData.observe(this) {
            binding.textView.text = it.toString()
        }

        binding.fab.setOnClickListener {
            viewModel.insertUser(User("Name $counter"))
            counter++
        }
    }
}