package com.example.demobuoi7

import android.app.Application

class Lec7Application : Application() {

    override fun onCreate() {
        super.onCreate()
        instace = this

    }

    companion object {
        lateinit var instace: Lec7Application

        fun getContext() = instace.applicationContext!!
    }
}