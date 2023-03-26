package com.demo_by_abhinav.android_assignment

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.demo_by_abhinav.android_assignment.ui.LoginScreen

class SplashScreen : AppCompatActivity() {
    private lateinit var ourSong: MediaPlayer
    private lateinit var audioManager: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        callthread()

    }

    private fun callthread() {
//        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
//        val attributes = AudioAttributes.Builder()
//            .setUsage(AudioAttributes.USAGE_MEDIA)
//            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//            .build()

        ourSong = MediaPlayer.create(this@SplashScreen, R.raw.assign_sound)
        ourSong.isLooping = true
        ourSong.start()
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
            ourSong.stop()
            finish()
        }, 5000)
    }
}
