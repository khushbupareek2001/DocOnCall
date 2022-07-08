package com.example.doconcall

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_form.*

class form : AppCompatActivity() {
    lateinit var nameinfouser: EditText
    lateinit var ageinfo: EditText
    lateinit var symptoms: EditText
    lateinit var gmaileinfo: EditText
    lateinit var gender:EditText
    lateinit var City:EditText
lateinit var surgery:EditText

    lateinit var refinfo: DatabaseReference
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        refinfo= FirebaseDatabase.getInstance().getReference("Patient")
        nameinfouser=findViewById(R.id.nameuserinfo)
        ageinfo=findViewById(R.id.age)
        symptoms=findViewById(R.id.disease)
        gmaileinfo=findViewById(R.id.gmail)
        gender=findViewById(R.id.gender)
        City=findViewById(R.id.city)
        surgery=findViewById(R.id.surgery)
    }

    fun storedata(view: View) {
        val names=nameinfouser.text.toString().trim()
        val ages=ageinfo.text.toString().trim()
        val dises=symptoms.text.toString().trim()
        val gmailes=gmaileinfo.text.toString().trim()
        val genders=gender.text.toString().trim()
        val cities=City.text.toString().trim()
        val surgeries=surgery.text.toString().trim()

        if(names.isEmpty()){
            nameuserinfo.error= "Please enter a name"
            return
        };
        if(ages.isEmpty()){
            ageinfo.error= "Please enter a age"
            return
        }
        if(dises.isEmpty()){
            symptoms.error= "Please enter a disease"
            return
        }
        if(gmailes.isEmpty()){
            gmaileinfo.error= "Please enter a gmail"
            return
        }
        if(genders.isEmpty()){
            gender.error= "Please enter a gmail"
            return
        }
        if(cities.isEmpty()){
            City.error= "Please enter a gmail"
            return
        }
        if(surgeries.isEmpty()){
            surgery.error= "Please enter a gmail"
            return
        }
        val p1=classy(names,gmailes,ages,genders,cities,dises,surgeries)
        val uid=refinfo.push().key.toString()
        refinfo.child(uid).setValue(p1)
        val uri = Uri.parse("smsto:9001858917")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", "Name:"+names+"\n Phone Number:"+gmailes+"\n Age:"+ages+"\n Gender:"+genders+"\n City:"+cities+"\n Symptoms:"+dises+"\n  Major Surgery:"+surgeries+"\n Request for appointment.")
        startActivity(intent)

    }
}
