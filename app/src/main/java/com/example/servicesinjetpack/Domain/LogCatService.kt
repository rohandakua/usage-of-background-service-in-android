package com.example.servicesinjetpack.Domain

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import com.example.servicesinjetpack.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ServiceScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext


class LogCatService : Service() {
   lateinit var player: MediaPlayer
    lateinit var  job: Job
    var isRunning : Boolean = false

    var i : Long = 0


    override fun onBind(p0: Intent?): IBinder? {return null
    }

    override fun onCreate() {
        super.onCreate()
    }



    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        isRunning = true
        job=CoroutineScope(Dispatchers.Default).launch {
            if(isRunning){
                while(true && i<1000000000){
                    delay(1000)
                    Log.d("from logCatService","IND" + " printing "+i++.toString() +" nth time ..... hahaha I am the evil")
                }
            }
        }
        // also making a tune to play when service is running
        player = MediaPlayer.create(this, R.raw.ohayo)
        player?.isLooping()

        player?.start()


        return START_STICKY

    }


    override fun onDestroy() {
        player?.stop() // stoping the music when the service is destroyed
        super.onDestroy()
        isRunning=false
        job.cancel()
        Log.d("from logCatService","service is destroyed")


    }


}