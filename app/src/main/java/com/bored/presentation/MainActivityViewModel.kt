package com.bored.presentation

import androidx.lifecycle.ViewModel
import com.bored.networking.ActivityDto
import com.bored.networking.BoredService
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val boredService: BoredService
): ViewModel() {

    fun downloadActivity(): Observable<ActivityDto> {
        return boredService.getActivity()
            .subscribeOn(Schedulers.io())
    }

}
