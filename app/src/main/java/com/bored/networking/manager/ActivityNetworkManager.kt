package com.bored.networking.manager

import com.bored.networking.service.BoredApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ActivityNetworkManager @Inject constructor(
    private val api: BoredApi
) {

    fun downloadActivity(): Observable<String> =
        api
            .getActivity()
            .map { it.activity }
            .subscribeOn(Schedulers.io())
}
