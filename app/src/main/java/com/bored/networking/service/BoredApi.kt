package com.bored.networking.service

import com.bored.networking.dto.ActivityDto
import io.reactivex.Observable
import retrofit2.http.GET

interface BoredApi {

    @GET("/api/activity/")
    fun getActivity(): Observable<ActivityDto>
}
