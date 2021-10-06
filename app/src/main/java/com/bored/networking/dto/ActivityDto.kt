package com.bored.networking.dto

data class ActivityDto(
    val activity: String,
    val type: String,
    val participants: Double,
    val price: Double,
    val link: String,
    val key: String,
    val accessibility: Double
)
