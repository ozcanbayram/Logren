package com.ozcanbayram.logren.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.ozcanbayram.logren.databinding.ActivityMainBinding
import com.ozcanbayram.logren.model.Term
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private lateinit var termArrayList : ArrayList<Term>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize Firebase Auth
        auth = Firebase.auth
        db = Firebase.firestore

        termArrayList = ArrayList<Term>()

        getData()

    }

    private fun getData(){
        db.collection("Terms").addSnapshotListener { value, error ->
            if(error != null){
                Toast.makeText(this@MainActivity,error.localizedMessage,Toast.LENGTH_LONG).show()
            }else{
                if(value != null){
                    if(!value.isEmpty){
                        val documents = value.documents
                        for (document in documents){
                            val term = document.get("Term") as String
                            val explanation = document.get("explanation") as String

                            println(term)

                            val terms = Term(term, explanation )
                            termArrayList.add(terms)


                        }
                    }
                }
            }
        }
    }

}