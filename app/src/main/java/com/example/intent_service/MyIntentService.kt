package com.example.intent_service

import android.app.IntentService
import android.content.Intent
import android.util.Log

// It won't support multithreading
// This IntentService will automatically run in the seperate Thread so not affect our main Thread

class MyIntentService : IntentService("MyIntentService"){

    init{
        instance = this
    }

    companion object{
        private lateinit var instance : MyIntentService
        var isRunning = false

        fun stopService(){
           Log.d("MyIntentService","Service is stopping...")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(p0: Intent?) {
      try{
          isRunning = true
          while(isRunning){
            Log.d("MyIntentService","Service is Running...")
              Thread.sleep(1000)
          }
      }catch (e : InterruptedException){
          Thread.currentThread().interrupt()
      }
    }


}