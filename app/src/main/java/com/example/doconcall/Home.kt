package com.example.doconcall

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth


class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var topdoc:com.google.android.material.imageview.ShapeableImageView
    lateinit var auth: FirebaseAuth
    lateinit var username:TextView
    lateinit var gmailuser:TextView
    lateinit var hView:View
    lateinit var userImage:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)



        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        hView=navView.getHeaderView(0)

        userImage=hView.findViewById(R.id.userImage)
        auth= FirebaseAuth.getInstance()
        val currentUser=auth.currentUser
        if(currentUser?.displayName!=null) {
            username=hView.findViewById(R.id.username)
            gmailuser=hView.findViewById(R.id.gmailUser)
            username.text = currentUser?.displayName
            gmailuser.text = currentUser?.email

        }

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homepage -> finish()
                R.id.alarm->{
                val intent= Intent(this,Alarm::class.java)
                startActivity(intent)}
                R.id.share -> {
                    val shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "https://www.google.com/");
                    startActivity(Intent.createChooser(shareIntent, "Share via"))
                }
                R.id.logout -> {
                    auth = FirebaseAuth.getInstance()
                    auth.signOut()
                    try {
                        // clearing app data
                        val packageName = applicationContext.packageName
                        val runtime = Runtime.getRuntime()
                        runtime.exec("pm clear $packageName")
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.emer -> {
                val intent = Intent(this, emergency::class.java)
                startActivity(intent)
                //Intent to share the text

                return true
            }
            R.id.panic->{
                if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(this,
                            arrayOf(Manifest.permission.SEND_SMS),
                            111)
                }
                    var sms = SmsManager.getDefault()
                    sms.sendTextMessage("8769020281","ME","You are my emergency contact, please help me. I am sending you my location:https://www.google.com/maps/dir//26.767764,75.852195/@26.7674886,75.7821439,12z?hl=en",null,null)
                    sms.sendTextMessage("9001858917","ME","You are my emergency contact, please help me. I am sending you my location:https://www.google.com/maps/dir//26.767764,75.852195/@26.7674886,75.7821439,12z?hl=en",null,null)
                    sms.sendTextMessage("8955663031","ME","You are my emergency contact, please help me. I am sending you my location:https://www.google.com/maps/dir//26.767764,75.852195/@26.7674886,75.7821439,12z?hl=en",null,null)
                Toast.makeText(this,"Message is sent",Toast.LENGTH_LONG).show()
                    return true
            }

            R.id.action_settings -> {
                val intent = Intent(this, aboutapp::class.java)
                startActivity(intent)
                return true
            }
            R.id.feedbackus -> {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "himanshudasingh@gmail.com"))
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Rating for the doc On Call app")
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    //TODO smth
                }
                return true
            }
            else->{
                return super.onOptionsItemSelected(item)
            }
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    fun docdata(view: View) {
        val inetent=Intent(this, doctordata::class.java)
        startActivity(inetent)
    }

    fun topdoc(view: View) {
        val intent=Intent(this, doctordata::class.java)
        startActivity(intent)
    }
    fun medicalnear(view: View) {
        val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/search/medical+shops+near+me")
        )
        startActivity(intent)
    }
    fun nearhosp(view: View) {
        val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/search/hospitals+near+me")
        )
        startActivity(intent)
    }



}