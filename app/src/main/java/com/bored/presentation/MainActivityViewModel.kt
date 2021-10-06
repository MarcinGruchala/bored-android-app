package com.bored.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bored.domain.manager.ActivityDomainManager
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val activityManager: ActivityDomainManager
): ViewModel() {

    private val _activity: MutableLiveData<String> =
        MutableLiveData()

    val activity: LiveData<String> =
        _activity

    fun downloadActivity() {
        activityManager.downloadActivity()
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: String) {
                    _activity.value = t
                    Log.d("Main", t)
                }

                override fun onError(e: Throwable) {
                    Log.d("Main","${e.message}")
                }

                override fun onComplete() {
                }
            })
    }

    fun onGetActivityClicked() {
        downloadActivity()
    }
}
