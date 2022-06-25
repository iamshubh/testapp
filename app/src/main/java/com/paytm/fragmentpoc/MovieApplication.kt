package com.paytm.fragmentpoc

import android.app.Application
import android.util.Log
import com.paytm.fragmentpoc.common.Constant
import com.paytm.fragmentpoc.common.DependencyProvider

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initialize()
        Log.d(Constant.TAG, "app created")
    }

    fun initialize() {
        DependencyProvider.inject(this)
    }
}