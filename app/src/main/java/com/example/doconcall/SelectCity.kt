package com.example.doconcall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth

class SelectCity : AppCompatActivity() {
//    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_city)
//        var currentUser=auth.currentUser

//        if(currentUser==null){
//            startActivity(Intent(this,MainActivity::class.java))
//            finish()
//        }


    }

    fun category(view: View) {
        val inetent=Intent(this,Home::class.java)
     startActivity(inetent)
    }
}