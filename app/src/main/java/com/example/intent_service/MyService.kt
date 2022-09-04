package com.example.intent_service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

// It support MultiThreading but it will run in the main thread by default
// so you should manually start a thread when creating such a service here
// otherwise ui might freeze


class MyService : Service(){

    val TAG = "MyService"

    init{
        Log.d(TAG,"Service is running...")
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG,dataString)
        }

        Thread{
            while(true){} // It is in our main thread so stop our app
        }.start()

        return START_STICKY // if the service is killed by the system it will recreated when possible
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Service is being killed...")
    }

}