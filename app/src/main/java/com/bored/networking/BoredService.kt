package com.bored.networking

import io.reactivex.Observable
import retrofit2.http.GET

interface BoredService {

    @GET("/api/activity/")
    fun getActivity(): Observable<ActivityDto>
}
