package com.ozcanbayram.logren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ozcanbayram.logren.databinding.ActivityWelcomeBinding
import com.ozcanbayram.logren.databinding.ActivityRegsiterBinding

class ActivityRegsiter : AppCompatActivity() {

    private lateinit var binding : ActivityRegsiterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegsiterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun register(view : View){

    }

}