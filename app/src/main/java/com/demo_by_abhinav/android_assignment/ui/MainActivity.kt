package com.demo_by_abhinav.android_assignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.demo_by_abhinav.android_assignment.adapter.MainAdapter
import com.demo_by_abhinav.android_assignment.model.MainRepository
import com.demo_by_abhinav.android_assignment.model.MainViewModel
import com.demo_by_abhinav.android_assignment.model.MyViewModelFactory
import com.demo_by_abhinav.android_assignment.R
import com.demo_by_abhinav.android_assignment.services.RetrofitService
import com.demo_by_abhinav.android_assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding:ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
        binding.recyclerview.adapter = adapter
        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllMovies()

        binding.buttonDetails.setOnClickListener {

            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "http://pandora.yilstaging.com/writable/uploads/20210127/1611811599_2ac19cd41e8387119d7e.mp3")
            startActivity(Intent.createChooser(sharingIntent, "Share URL via"))
        }
    }
}