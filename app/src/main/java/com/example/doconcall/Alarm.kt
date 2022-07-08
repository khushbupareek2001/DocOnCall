package com.example.doconcall

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import java.util.*

class Alarm : AppCompatActivity() {
    lateinit var am: AlarmManager
    lateinit var tp: TimePicker
    lateinit var update_Text: TextView
    lateinit var con: Context
    lateinit var buttonStart: Button
    lateinit var buttonEnd: Button
    var hour:Int=0
    var min:Int=0
    lateinit var pi: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        this.con=this
        am=getSystemService(Context.ALARM_SERVICE) as AlarmManager
        tp=findViewById(R.id.tp) as TimePicker
        update_Text=findViewById(R.id.update_text) as TextView
        buttonStart=findViewById(R.id.start_alarm) as Button
        buttonEnd=findViewById(R.id.stop_alarm) as Button
        var calender: Calendar = Calendar.getInstance()
        var myIntent: Intent = Intent(this,AlarmReceiver::class.java)
        buttonStart.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                    calender.set(Calendar.HOUR_OF_DAY,tp.hour)
                    calender.set(Calendar.MINUTE,tp.minute)
                    calender.set(Calendar.SECOND,0)
                    calender.set(Calendar.MILLISECOND,0)
                    hour=tp.hour
                    min=tp.minute
                }
                else{
                    calender.set(Calendar.HOUR_OF_DAY,tp.currentHour)
                    calender.set(Calendar.MINUTE,tp.currentMinute)
                    calender.set(Calendar.SECOND,0)
                    calender.set(Calendar.MILLISECOND,0)
                    hour=tp.currentHour
                    min=tp.currentMinute
                }
                var hr_str:String=hour.toString()
                var min_str:String=min.toString()
                if(hour>12){
                    hr_str=(hour-12).toString()

                }
                if(min<10){
                    min_str="0$min"

                }
                set_alarm_text("Alarm set to: $hr_str: $min_str")
                myIntent.putExtra("extra","on")
                pi=PendingIntent.getBroadcast(this@Alarm,0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT)
                am.setExact(AlarmManager.RTC_WAKEUP,calender.timeInMillis,pi)

            }
        })
        buttonEnd.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                set_alarm_text("Alarm off")
                pi=  PendingIntent.getBroadcast(this@Alarm,0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT)
                am.cancel(pi)
                myIntent.putExtra("extra","off")
                sendBroadcast(myIntent)
            }
        })
    }
    private fun set_alarm_text(s:String){
        update_Text.setText(s)
    }

    }
