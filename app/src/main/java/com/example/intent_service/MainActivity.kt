package com.example.intent_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val btnStartService = findViewById<Button>(R.id.btnServiceStart)
       val btnStopService = findViewById<Button>(R.id.btn_ServiceStop)
        val tvServiceInfo = findViewById<TextView>(R.id.tvServiceInfo)
        val btnSendData = findViewById<Button>(R.id.btnSendData)
        val etData = findViewById<EditText>(R.id.edt_data)

//        btnStartService.setOnClickListener{
//           Intent(this,MyIntentService::class.java).also {
//               startService(it)
//               tvServiceInfo.text = "Service Started"
//
//           }
//        }
//
//        btnStopService.setOnClickListener{
//            MyIntentService.stopService()
//            tvServiceInfo.text = "Service Stopped"
//        }

        // using MyService

        btnStartService.setOnClickListener{
            Intent(this,MyService::class.java).also{
                startService(it)
                tvServiceInfo.text = "Service started"
            }
        }
        btnStopService.setOnClickListener{
            Intent(this,MyService::class.java).also{
                stopService(it)
                tvServiceInfo.text = "Service stopped"
            }
        }
        btnSendData.setOnClickListener{
            Intent(this,MyService::class.java).also{
                val dataString = etData.text.toString()
                it.putExtra("EXTRA_DATA",dataString)
                startService(it)
            }
        }

    }
}