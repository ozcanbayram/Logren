package com.ozcanbayram.logren.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ozcanbayram.logren.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize Firebase Auth
        auth = Firebase.auth



    }
    fun login(view : View){
        val email = binding.editTextText.text.toString()
        val password = binding.editTextTextPassword2.text.toString()

        if(email.equals("")||password.equals("")){
            Toast.makeText(this,"Lütfen E-posta ve Şifre bilgilerinizi giriniz.", Toast.LENGTH_LONG).show()
        }else{
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                Toast.makeText(this@LoginActivity,"Giriş başarılı.", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@LoginActivity,it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}