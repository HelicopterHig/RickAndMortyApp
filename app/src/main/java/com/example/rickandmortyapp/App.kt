package com.example.rickandmortyapp

import android.app.Application
import com.example.rickandmortyapp.di.AppComponent
import com.example.rickandmortyapp.di.AppModule
import com.example.rickandmortyapp.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}