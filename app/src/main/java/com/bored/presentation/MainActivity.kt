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


        binding.btnGetActivity.setOnClickListener {
            viewModel.downloadActivity()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ActivityDto> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: ActivityDto) {
                        binding.tvActivity.text = t.activity
                    }

                    override fun onError(e: Throwable) {
                        Log.d("MainActivity", "${e.message}")
                    }

                    override fun onComplete() {
                    }
                })
        }

    }
}
