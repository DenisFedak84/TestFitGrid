package com.example.testfitgridgraph


import android.app.Application
import com.example.testfitgridgraph.di.AppComponent
import com.example.testfitgridgraph.di.AppContextModule
import com.example.testfitgridgraph.di.DaggerAppComponent


class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
        INSTANCE = this
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(AppContextModule(this)).build()
    }

    companion object {
        lateinit var INSTANCE: App
    }

}