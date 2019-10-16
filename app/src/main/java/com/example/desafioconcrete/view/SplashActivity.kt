package com.example.desafioconcrete.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.desafioconcrete.R
import com.example.desafioconcrete.repository.BaseRepository
import com.example.desafioconcrete.viewmodel.MainViewModel

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent = Intent(this,MainActivity::class.java)
        var handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {

                startActivity(intent)
                finish()

            }
        },500)


    }
}


