package com.example.doconcall

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class emergency : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)
    }
    fun nearhosp(view: View) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("google.navigation:q=hospital")
        )
        startActivity(intent)
    }
    fun callemer(view: View) {
        val intent= Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + "102"))
        startActivity(intent)
        Toast.makeText(this, "Call is going", Toast.LENGTH_LONG).show()
    }
}