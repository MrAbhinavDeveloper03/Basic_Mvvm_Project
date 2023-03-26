package com.demo_by_abhinav.android_assignment.model

import com.demo_by_abhinav.android_assignment.services.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()

}