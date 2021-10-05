package com.bored.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bored.databinding.ActivityMainBinding
import com.bored.networking.ActivityDto
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeEvents()

        setOnClickListeners()
    }

    private fun showNewActivity(){
        binding.tvActivity.text = viewModel.activity.value
    }

    private fun setOnClickListeners() {
        binding.btnGetActivity.setOnClickListener {
            viewModel.downloadActivity()
        }
    }

    private fun observeEvents() {
        viewModel.activity
            .observe(this) { showNewActivity() }
    }
}

