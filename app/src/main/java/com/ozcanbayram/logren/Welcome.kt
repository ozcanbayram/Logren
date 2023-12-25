package com.ozcanbayram.logren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ozcanbayram.logren.databinding.ActivityMainBinding

class Welcome : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.registerButton.setOnClickListener {
            val intent = Intent(this@Welcome, ActivityRegsiter::class.java)
            startActivity(intent)
        }


    }

    private fun register(view : View){

    }

    private fun login(view : View){

    }

}