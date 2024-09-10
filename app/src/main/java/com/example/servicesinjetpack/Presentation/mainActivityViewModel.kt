package com.example.servicesinjetpack.Presentation

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.servicesinjetpack.Domain.LogCatService
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class mainActivityViewModel @Inject constructor(private  val logCatService: LogCatService) : ViewModel() {

    fun startService(context: Context){
        val intent = Intent(context, LogCatService::class.java)
        // start the service
        context.startService(intent)

    }

    fun destroyService(){
        logCatService.onDestroy()
    }



}