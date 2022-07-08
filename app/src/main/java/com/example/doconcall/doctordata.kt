package com.example.doconcall

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class doctordata : AppCompatActivity() {
    lateinit var doc1start:TextView
    lateinit var doc2start:TextView
    lateinit var doc3start:TextView
    lateinit var doc1end:TextView
    lateinit var doc2end:TextView
    lateinit var doc3end:TextView
lateinit var doc1vanc:TextView
    lateinit var doc2vanc:TextView
    lateinit var doc3vanc:TextView


    lateinit var jaipurdoc1name:TextView
    lateinit var jaipurdoc1degree:TextView
    lateinit var jaipurdoc1experience:TextView
    lateinit var jaipurdoc1address:TextView
    lateinit var jaipurdoc1hospital:TextView
    lateinit var jaipurdoc1fee:TextView
    lateinit var jaipurdoc1location:String
    lateinit var jaipurdoc1phoneNumber:String
    lateinit var jaipurdoc2name:TextView
    lateinit var jaipurdoc2degree:TextView
    lateinit var jaipurdoc2experience:TextView
    lateinit var jaipurdoc2address:TextView
    lateinit var jaipurdoc2hospital:TextView
    lateinit var jaipurdoc2fee:TextView
    lateinit var jaipurdoc2location:String
    lateinit var jaipurdoc2phoneNumber:String
    lateinit var jaipurdoc3name:TextView
    lateinit var jaipurdoc3degree:TextView
    lateinit var jaipurdoc3experience:TextView
    lateinit var jaipurdoc3address:TextView
    lateinit var jaipurdoc3hospital:TextView
    lateinit var jaipurdoc3fee:TextView
    lateinit var jaipurdoc3location:String
    lateinit var jaipurdoc3phoneNumber:String
    lateinit var jaipurdoc4name:TextView
    lateinit var jaipurdoc4degree:TextView
    lateinit var jaipurdoc4experience:TextView
    lateinit var jaipurdoc4address:TextView
    lateinit var jaipurdoc4hospital:TextView
    lateinit var jaipurdoc4fee:TextView
    lateinit var jaipurdoc4location:String
    lateinit var jaipurdoc4phoneNumber:String
    lateinit var jaipurdoc5name:TextView
    lateinit var jaipurdoc5degree:TextView
    lateinit var jaipurdoc5experience:TextView
    lateinit var jaipurdoc5address:TextView
    lateinit var jaipurdoc5hospital:TextView
    lateinit var jaipurdoc5fee:TextView
    lateinit var jaipurdoc5location:String
    lateinit var jaipurdoc5phoneNumber:String
    lateinit var refdoctor1: DatabaseReference
    lateinit var refdoctor1degree: DatabaseReference
    lateinit var refdoctor1experience: DatabaseReference
    lateinit var refdoctor1address: DatabaseReference
    lateinit var refdoctor1hospital: DatabaseReference
    lateinit var refdoctor1fee: DatabaseReference
    lateinit var refdoctor1location:DatabaseReference
    lateinit var refdoctor1phonenumber:DatabaseReference


    lateinit var refdoctor2: DatabaseReference
    lateinit var refdoctor2degree: DatabaseReference
    lateinit var refdoctor2experience: DatabaseReference
    lateinit var refdoctor2address: DatabaseReference
    lateinit var refdoctor2hospital: DatabaseReference
    lateinit var refdoctor2fee: DatabaseReference
    lateinit var refdoctor2location: DatabaseReference
    lateinit var refdoctor2Phonenumber: DatabaseReference


    lateinit var refdoctor3: DatabaseReference
    lateinit var refdoctor3degree: DatabaseReference
    lateinit var refdoctor3experience: DatabaseReference
    lateinit var refdoctor3address: DatabaseReference
    lateinit var refdoctor3hospital: DatabaseReference
    lateinit var refdoctor3fee: DatabaseReference
    lateinit var refdoctor3location: DatabaseReference
    lateinit var refdoctor3Phonenumber: DatabaseReference


    lateinit var refdoctor4: DatabaseReference
    lateinit var refdoctor4degree: DatabaseReference
    lateinit var refdoctor4experience: DatabaseReference
    lateinit var refdoctor4address: DatabaseReference
    lateinit var refdoctor4hospital: DatabaseReference
    lateinit var refdoctor4fee: DatabaseReference
    lateinit var refdoctor4location: DatabaseReference
    lateinit var refdoctor4Phonenumber: DatabaseReference

    lateinit var refdoctor5: DatabaseReference
    lateinit var refdoctor5degree: DatabaseReference
    lateinit var refdoctor5experience: DatabaseReference
    lateinit var refdoctor5address: DatabaseReference
    lateinit var refdoctor5hospital: DatabaseReference
    lateinit var refdoctor5fee: DatabaseReference
    lateinit var refdoctor5location: DatabaseReference
    lateinit var refdoctor5Phonenumber: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctordata)

        jaipurdoc1name=findViewById(R.id.doc1)
        jaipurdoc1address=findViewById(R.id.doc1add)
        jaipurdoc1degree=findViewById(R.id.doc1degree)
        jaipurdoc1experience=findViewById(R.id.doc1exp)
        jaipurdoc1hospital=findViewById(R.id.doc1hosp)
        jaipurdoc1fee=findViewById(R.id.doc1fee)
        jaipurdoc2name=findViewById(R.id.doc2)
        jaipurdoc2address=findViewById(R.id.doc2add)
        jaipurdoc2degree=findViewById(R.id.doc2degree)
        jaipurdoc2experience=findViewById(R.id.doc2exp)
        jaipurdoc2hospital=findViewById(R.id.doc2hosp)
        jaipurdoc2fee=findViewById(R.id.doc2fee)
        jaipurdoc3name=findViewById(R.id.doc3)
        jaipurdoc3address=findViewById(R.id.doc3add)
        jaipurdoc3degree=findViewById(R.id.doc3degree)
        jaipurdoc3experience=findViewById(R.id.doc3exp)
        jaipurdoc3hospital=findViewById(R.id.doc3hosp)
        jaipurdoc3fee=findViewById(R.id.doc3fee)
        jaipurdoc4name=findViewById(R.id.doc4)
        jaipurdoc4address=findViewById(R.id.doc4add)
        jaipurdoc4degree=findViewById(R.id.doc4degree)
        jaipurdoc4experience=findViewById(R.id.doc4exp)
        jaipurdoc4hospital=findViewById(R.id.doc4hosp)
        jaipurdoc4fee=findViewById(R.id.doc4fee)
        jaipurdoc5name=findViewById(R.id.doc5)
        jaipurdoc5address=findViewById(R.id.doc5add)
        jaipurdoc5degree=findViewById(R.id.doc5degree)
        jaipurdoc5experience=findViewById(R.id.doc5exp)
        jaipurdoc5hospital=findViewById(R.id.doc5hosp)
        jaipurdoc5fee=findViewById(R.id.doc5fee)
        refdoctor1= FirebaseDatabase.getInstance().getReference("JaipurDoctor1Name")
        refdoctor1degree= FirebaseDatabase.getInstance().getReference("JaipurDoctor1Degree")
        refdoctor1experience= FirebaseDatabase.getInstance().getReference("JaipurDoctor1experience")
        refdoctor1address= FirebaseDatabase.getInstance().getReference("JaipurDoctor1Address")
        refdoctor1hospital= FirebaseDatabase.getInstance().getReference("JaipurDoctor1Hospital")
        refdoctor1fee= FirebaseDatabase.getInstance().getReference("JaipurDoctor1Fee")
        refdoctor1location= FirebaseDatabase.getInstance().getReference("JaipurDoctor1Location")
        refdoctor1phonenumber=FirebaseDatabase.getInstance().getReference("JaipurDoctor1Phonenumber")

        refdoctor2= FirebaseDatabase.getInstance().getReference("JaipurDoctor2Name")
        refdoctor2degree= FirebaseDatabase.getInstance().getReference("JaipurDoctor2Degree")
        refdoctor2experience= FirebaseDatabase.getInstance().getReference("JaipurDoctor2Experience")
        refdoctor2address= FirebaseDatabase.getInstance().getReference("JaipurDoctor2Address")
        refdoctor2hospital= FirebaseDatabase.getInstance().getReference("JaipurDoctor2Hospital")
        refdoctor2fee= FirebaseDatabase.getInstance().getReference("JaipurDoctor2Fee")
        refdoctor2location= FirebaseDatabase.getInstance().getReference("JaipurDoctor2Location")
        refdoctor2Phonenumber=FirebaseDatabase.getInstance().getReference("JaipurDoctor2Phonenumber")

        refdoctor3= FirebaseDatabase.getInstance().getReference("JaipurDoctor3Name")
        refdoctor3degree= FirebaseDatabase.getInstance().getReference("JaipurDoctor3Degree")
        refdoctor3experience= FirebaseDatabase.getInstance().getReference("JaipurDoctor3Experience")
        refdoctor3address= FirebaseDatabase.getInstance().getReference("JaipurDoctor3Address")
        refdoctor3hospital= FirebaseDatabase.getInstance().getReference("JaipurDoctor3Hospital")
        refdoctor3fee= FirebaseDatabase.getInstance().getReference("JaipurDoctor3Fee")
        refdoctor3location= FirebaseDatabase.getInstance().getReference("JaipurDoctor3Location")
        refdoctor3Phonenumber=FirebaseDatabase.getInstance().getReference("JaipurDoctor3Phonenumber")

        refdoctor4= FirebaseDatabase.getInstance().getReference("JaipurDoctor4Name")
        refdoctor4degree= FirebaseDatabase.getInstance().getReference("JaipurDoctor4Degree")
        refdoctor4experience= FirebaseDatabase.getInstance().getReference("JaipurDoctor4Experience")
        refdoctor4address= FirebaseDatabase.getInstance().getReference("JaipurDoctor4Address")
        refdoctor4hospital= FirebaseDatabase.getInstance().getReference("JaipurDoctor4Hospital")
        refdoctor4fee= FirebaseDatabase.getInstance().getReference("JaipurDoctor4Fee")
        refdoctor4location= FirebaseDatabase.getInstance().getReference("JaipurDoctor4Location")
        refdoctor4Phonenumber=FirebaseDatabase.getInstance().getReference("JaipurDoctor4Phonenumber")

        refdoctor5= FirebaseDatabase.getInstance().getReference("JaipurDoctor5Name")
        refdoctor5degree= FirebaseDatabase.getInstance().getReference("JaipurDoctor5Degree")
        refdoctor5experience= FirebaseDatabase.getInstance().getReference("JaipurDoctor5Experience")
        refdoctor5address= FirebaseDatabase.getInstance().getReference("JaipurDoctor5Address")
        refdoctor5hospital= FirebaseDatabase.getInstance().getReference("JaipurDoctor5Hospital")
        refdoctor5fee= FirebaseDatabase.getInstance().getReference("JaipurDoctor5Fee")
        refdoctor5location= FirebaseDatabase.getInstance().getReference("JaipurDoctor5Location")
        refdoctor5Phonenumber=FirebaseDatabase.getInstance().getReference("JaipurDoctor5Phonenumber")

//        val doctor1nametext=jaipurdoc1name.text.toString()
//        val doctor1addresstext=jaipurdoc1address.text.toString()
//        val doctor1degreeetext=jaipurdoc1degree.text.toString()
//        val doctor1experiencetext=jaipurdoc1experience.text.toString()
//        val doctor1hosptext=jaipurdoc1hospital.text.toString()
//        val doctor1feetext=jaipurdoc1fee.text.toString()
//
//        val doctor2nametext=jaipurdoc2name.text.toString()
//        val doctor2addresstext=jaipurdoc2address.text.toString()
//        val doctor2degreeetext=jaipurdoc2degree.text.toString()
//        val doctor2experiencetext=jaipurdoc2experience.text.toString()
//        val doctor2hosptext=jaipurdoc2hospital.text.toString()
//        val doctor2feetext=jaipurdoc2fee.text.toString()
//
//        val doctor3nametext=jaipurdoc3name.text.toString()
//        val doctor3addresstext=jaipurdoc3address.text.toString()
//        val doctor3degreeetext=jaipurdoc3degree.text.toString()
//        val doctor3experiencetext=jaipurdoc3experience.text.toString()
//        val doctor3hosptext=jaipurdoc3hospital.text.toString()
//        val doctor3feetext=jaipurdoc3fee.text.toString()
//
//        val doctor4nametext=jaipurdoc4name.text.toString()
//        val doctor4addresstext=jaipurdoc4address.text.toString()
//        val doctor4degreeetext=jaipurdoc4degree.text.toString()
//        val doctor4experiencetext=jaipurdoc4experience.text.toString()
//        val doctor4hosptext=jaipurdoc4hospital.text.toString()
//        val doctor4feetext=jaipurdoc4fee.text.toString()
//
//
//        val doctor5nametext=jaipurdoc5name.text.toString()
//        val doctor5addresstext=jaipurdoc5address.text.toString()
//        val doctor5degreeetext=jaipurdoc5degree.text.toString()
//        val doctor5experiencetext=jaipurdoc5experience.text.toString()
//        val doctor5hosptext=jaipurdoc5hospital.text.toString()
//        val doctor5feetext=jaipurdoc5fee.text.toString()

//
//        refdoctor1.setValue(doctor1nametext)
//        refdoctor1degree.setValue(doctor1degreeetext)
//        refdoctor1experience.setValue(doctor1experiencetext)
//        refdoctor1address.setValue(doctor1addresstext)
//        refdoctor1hospital.setValue(doctor1hosptext)
//        refdoctor1fee.setValue(doctor1feetext)

//        refdoctor2.setValue(doctor2nametext)
//        refdoctor2degree.setValue(doctor2degreeetext)
//        refdoctor2experience.setValue(doctor2experiencetext)
//        refdoctor2address.setValue(doctor2addresstext)
//        refdoctor2hospital.setValue(doctor2hosptext)
//        refdoctor2fee.setValue(doctor2feetext)
//
//        refdoctor3.setValue(doctor3nametext)
//        refdoctor3degree.setValue(doctor3degreeetext)
//        refdoctor3experience.setValue(doctor3experiencetext)
//        refdoctor3address.setValue(doctor3addresstext)
//        refdoctor3hospital.setValue(doctor3hosptext)
//        refdoctor3fee.setValue(doctor3feetext)
//
//        refdoctor4.setValue(doctor4nametext)
//        refdoctor4degree.setValue(doctor4degreeetext)
//        refdoctor4experience.setValue(doctor4experiencetext)
//        refdoctor4address.setValue(doctor4addresstext)
//        refdoctor4hospital.setValue(doctor4hosptext)
//        refdoctor4fee.setValue(doctor4feetext)
//
//        refdoctor5.setValue(doctor5nametext)
//        refdoctor5degree.setValue(doctor5degreeetext)
//        refdoctor5experience.setValue(doctor5experiencetext)
//        refdoctor5address.setValue(doctor5addresstext)
//        refdoctor5hospital.setValue(doctor5hosptext)
//        refdoctor5fee.setValue(doctor5feetext)
//
//

        jaipurdoc1phoneNumber="1234"
//        refdoctor1phonenumber.setValue(jaipurdoc1phoneNumber)
        jaipurdoc1location="http://maps.google.com/maps?daddr=26.9137, 75.8127"
//        refdoctor1location.setValue(jaipurdoc1location)

        jaipurdoc2phoneNumber="9001"
        jaipurdoc3phoneNumber="889"
        jaipurdoc4phoneNumber="876"
        jaipurdoc5phoneNumber="88906"
//        refdoctor1phonenumber.setValue(jaipurdoc1phoneNumber)
//        refdoctor2Phonenumber.setValue(jaipurdoc2phoneNumber)
//        refdoctor3Phonenumber.setValue(jaipurdoc3phoneNumber)
//        refdoctor4Phonenumber.setValue(jaipurdoc4phoneNumber)
//        refdoctor5Phonenumber.setValue(jaipurdoc5phoneNumber)

        jaipurdoc2location="http://maps.google.com/maps?daddr=26.9137, 75.8127"
        jaipurdoc3location="http://maps.google.com/maps?daddr=26.7701, 75.8546"
        jaipurdoc4location="http://maps.google.com/maps?daddr=26.9137, 75.8127"
        jaipurdoc5location="http://maps.google.com/maps?daddr=26.7701, 75.8546"
//        refdoctor2location.setValue(jaipurdoc2location)
//        refdoctor3location.setValue(jaipurdoc3location)
//        refdoctor4location.setValue(jaipurdoc4location)
//        refdoctor5location.setValue(jaipurdoc5location)


        refdoctor1location.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc1location=snapshot.value.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor1phonenumber.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc1phoneNumber=snapshot.value.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor2location.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc2location=snapshot.value.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor2Phonenumber.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc2phoneNumber=snapshot.value.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor3location.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc3location=snapshot.value.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor3Phonenumber.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc3phoneNumber=snapshot.value.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor4location.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc4location=snapshot.value.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor4Phonenumber.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc4phoneNumber=snapshot.value.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor5location.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc5location=snapshot.value.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor5Phonenumber.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc5phoneNumber=snapshot.value.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor1.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc1name.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        refdoctor1degree.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc1degree.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor1experience.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc1experience.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor1address.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc1address.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor1hospital.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc1hospital.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor1fee.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc1fee.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor2.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc2name.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor2degree.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc2degree.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor2experience.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc2experience.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor2address.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc1address.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor2hospital.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc2hospital.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor2fee.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc2fee.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })








        refdoctor3.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc3name.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor3degree.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc3degree.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor3experience.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc3experience.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor3address.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc3address.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor3hospital.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc3hospital.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor3fee.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc3fee.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })









        refdoctor4.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc4name.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor4degree.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc4degree.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor4experience.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc4experience.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor4address.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc4address.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor4hospital.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc4hospital.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor4fee.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc4fee.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })







        refdoctor5.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc5name.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor5degree.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc5degree.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor5experience.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc5experience.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor5address.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc5address.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor5hospital.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc5hospital.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        refdoctor5fee.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()){
                    jaipurdoc5fee.setText(snapshot.value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

    fun locatedoc1(view: View) {
        val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(jaipurdoc1location)
        )
        startActivity(intent)
    }
    fun calldoc1(view: View) {
        val intent=Intent(Intent.ACTION_DIAL)
        intent.data= Uri.parse("tel:" + jaipurdoc1phoneNumber)
        startActivity(intent)
    }
    fun calldoc2(view: View) {

        val intent=Intent(Intent.ACTION_DIAL)
        intent.data= Uri.parse("tel:" + jaipurdoc3phoneNumber)
        startActivity(intent)
    }
    fun locatedoc2(view: View) {
        val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(jaipurdoc2location)
        )
        startActivity(intent)
    }
    fun calldoc3(view: View) {
        val intent=Intent(Intent.ACTION_DIAL)
        intent.data= Uri.parse("tel:" + jaipurdoc4phoneNumber)
        startActivity(intent)
    }
    fun locatedoc3(view: View) {
        val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(jaipurdoc5location)
        )
        startActivity(intent)
    }

    fun bookdoc1(view: View) {
        val intent=Intent(this,form::class.java)
        startActivity(intent)
    }
}