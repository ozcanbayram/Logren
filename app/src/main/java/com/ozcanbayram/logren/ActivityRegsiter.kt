package com.ozcanbayram.logren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.ozcanbayram.logren.databinding.ActivityWelcomeBinding
import com.ozcanbayram.logren.databinding.ActivityRegsiterBinding

class ActivityRegsiter : AppCompatActivity() {

    private lateinit var binding : ActivityRegsiterBinding
    //For Firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegsiterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize Firebase Auth
        auth = Firebase.auth


    }
    fun register(view : View){
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this@ActivityRegsiter,"Lütfen E-Posta ve Parolanızı eksiksiz giriniz.",Toast.LENGTH_LONG).show()
        }else {

            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener { authResult ->
                val newuser =authResult.user
                Toast.makeText(this@ActivityRegsiter,"Kayıt Başarılı. Giriş Yapabilirsiniz.",Toast.LENGTH_LONG).show()
                val intent = Intent(this@ActivityRegsiter,LoginActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this@ActivityRegsiter, it.localizedMessage, Toast.LENGTH_LONG).show()
            }

        }
    }


}