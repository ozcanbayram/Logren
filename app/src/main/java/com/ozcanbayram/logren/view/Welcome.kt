package com.ozcanbayram.logren.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.ozcanbayram.logren.databinding.ActivityWelcomeBinding

class Welcome : AppCompatActivity() {

    private lateinit var binding : ActivityWelcomeBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.registerButton.setOnClickListener {
            val intent = Intent(this@Welcome, ActivityRegsiter::class.java)
            startActivity(intent)
        }

        binding.loginButton.setOnClickListener {
            val intent = Intent(this@Welcome, LoginActivity::class.java)
            startActivity(intent)
        }

        auth = Firebase.auth
        val currentUSer = auth.currentUser //Hatırlama kontrolü ->
        if(currentUSer != null){
            val intent = Intent(this@Welcome,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun register(view : View){

    }

    private fun login(view : View){

    }

}