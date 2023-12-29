package com.ozcanbayram.logren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozcanbayram.logren.databinding.ActivityDetailsBinding
import com.ozcanbayram.logren.databinding.ActivityLoginBinding

class Details : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val term = intent.getStringExtra("term")
        val explanation = intent.getStringExtra("explanation")

        binding.header.text = term
        binding.explanation.text = explanation
    }
}