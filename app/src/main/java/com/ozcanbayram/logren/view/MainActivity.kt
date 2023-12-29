package com.ozcanbayram.logren.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import com.ozcanbayram.logren.R
import com.ozcanbayram.logren.adapter.TermsAdapter
import com.ozcanbayram.logren.databinding.ActivityMainBinding
import com.ozcanbayram.logren.model.Term
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private lateinit var termArrayList : ArrayList<Term>
    private lateinit var termsAdapter : TermsAdapter
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


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        termsAdapter = TermsAdapter(termArrayList)
        binding.recyclerView.adapter = termsAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.log_out){
            auth.signOut()
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getData(){
        db.collection("Terms").orderBy("term", Query.Direction.ASCENDING).addSnapshotListener { value, error ->
            if(error != null){
                Toast.makeText(this@MainActivity,error.localizedMessage,Toast.LENGTH_LONG).show()
            }else{
                if(value != null){
                    if(!value.isEmpty){
                        val documents = value.documents
                        for (document in documents){
                            val term = document.get("term") as String
                            val explanation = document.get("explanation") as String


                            val terms = Term(term, explanation )
                            termArrayList.add(terms)
                        }
                        termsAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

}