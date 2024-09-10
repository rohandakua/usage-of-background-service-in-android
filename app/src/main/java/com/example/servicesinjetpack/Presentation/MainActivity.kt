package com.example.servicesinjetpack.Presentation

import android.app.Application
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.servicesinjetpack.Domain.LogCatService
import com.example.servicesinjetpack.ui.theme.ServicesInJetpackTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ServicesInJetpackTheme {
                mainScreen()

            }
        }
    }
}

@Preview
@Composable
private fun preview() {
    mainScreen()
    
}

@Composable
fun mainScreen ( modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val intent = remember {
        Intent(context, LogCatService::class.java)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp))
    Column (
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = { context.startService(intent)}){
            Text(text = "Click")
            
        }
        Button(onClick = { context.stopService(intent)}){
            Text(text = "Click to destroy")

        }
    }
}
