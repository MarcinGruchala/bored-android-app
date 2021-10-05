package com.bored.domain.manager

import com.bored.networking.manager.ActivityNetworkManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject


class ActivityDomainManager @Inject constructor(
    private val network: ActivityNetworkManager
)  {

    fun downloadActivity(): Observable<String> =
        network
            .downloadActivity()
            .observeOn(AndroidSchedulers.mainThread())
}
