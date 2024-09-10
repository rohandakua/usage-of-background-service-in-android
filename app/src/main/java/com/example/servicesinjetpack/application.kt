package com.example.servicesinjetpack

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class application() : Application() {
    override fun onCreate() {
        super.onCreate()

    }

}