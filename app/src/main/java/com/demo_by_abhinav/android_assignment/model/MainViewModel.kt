package com.demo_by_abhinav.android_assignment.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<Data_value>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<Data_value>> {
            override fun onResponse(call: Call<List<Data_value>>, response: Response<List<Data_value>>) {
                movieList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Data_value>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}