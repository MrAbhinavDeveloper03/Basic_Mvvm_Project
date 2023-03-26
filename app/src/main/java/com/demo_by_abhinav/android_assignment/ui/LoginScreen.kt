package com.demo_by_abhinav.android_assignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.demo_by_abhinav.android_assignment.R
import com.demo_by_abhinav.android_assignment.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {
    lateinit var binding: ActivityLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login_screen)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_screen)

        binding.loginbtn.setOnClickListener {
            Toast.makeText(this, "sdfdsf", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }



    }

}